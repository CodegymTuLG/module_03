package controller;

import respository.renttypemaster.RentTypeMasterRespository;
import respository.service.ServiceRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;
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
    private ServiceRespository serviceDAO;
    private ServiceTypeMasterRespository serviceTypeMasterDAO;
    private RentTypeMasterRespository rentTypeMasterDAO;

    public void init() {
        serviceDAO = new ServiceRespository();
        serviceTypeMasterDAO = new ServiceTypeMasterRespository();
        rentTypeMasterDAO = new RentTypeMasterRespository();
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

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        int rentprice = Integer.parseInt(request.getParameter("rentprice"));
        int maxperson = Integer.parseInt(request.getParameter("maxperson"));
        int renttype_id = Integer.parseInt(request.getParameter("renttype_id"));
        int servicetype_id = Integer.parseInt(request.getParameter("servicetype_id"));
        String standar = request.getParameter("standar");
        String other_service_description = request.getParameter("other_service_description");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String free_service = request.getParameter("free_service");
        Service service = new Service(name, area, rentprice, maxperson, renttype_id, servicetype_id, standar, other_service_description, pool_area, floor, free_service);
        serviceDAO.insertService(service);
        listService(request,response);
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
