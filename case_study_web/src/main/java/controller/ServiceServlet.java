package controller;

import dao.renttypemaster.RentTypeMasterDAO;
import dao.service.ServiceDAO;
import dao.servicetypemaster.ServiceTypeMasterDAO;
import model.RentTypeMaster;
import model.Service;
import model.ServiceTypeMaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceDAO serviceDAO;
    private ServiceTypeMasterDAO serviceTypeMasterDAO;
    private RentTypeMasterDAO rentTypeMasterDAO;

    public void init() {
        serviceDAO = new ServiceDAO();
        serviceTypeMasterDAO = new ServiceTypeMasterDAO();
        rentTypeMasterDAO = new RentTypeMasterDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertService(request, response);
                break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Service service = new Service(name, email, country);
        serviceDAO.insertService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
                case "create":
                showNewForm(request, response);
                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                deleteUser(request, response);
//                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceTypeMaster> serviceTypeMasterList = serviceTypeMasterDAO.selectAllServiceTypeMaster();
        request.setAttribute("serviceTypeMasterList", serviceTypeMasterList);

        List<RentTypeMaster> rentTypeMasterList = rentTypeMasterDAO.selectAllRentTypeMaster();
        request.setAttribute("rentTypeMasterList", rentTypeMasterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceDAO.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/service.jsp");
        dispatcher.forward(request, response);
    }
}
