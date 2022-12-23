package controller;

import model.RentTypeMaster;
import model.Service;
import model.ServiceTypeMaster;
import service.renttypemaster.FacilityRentTypeMaster;
import service.renttypemaster.IFacilityRentTypeMaster;
import service.service.FacilityService;
import service.service.IFacilityService;
import service.servicetypemaster.FacilityServiceTypeMaster;
import service.servicetypemaster.IFacilityServiceTypeMaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IFacilityService facilityService = new FacilityService();
    private IFacilityServiceTypeMaster facilityServiceTypeMaster = new FacilityServiceTypeMaster();
    private IFacilityRentTypeMaster iFacilityRentTypeMaster = new FacilityRentTypeMaster();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertService(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
        }
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
            default:
                listService(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

        List<Service> serviceList = facilityService.selectAllService();
        List<ServiceTypeMaster> serviceTypeMasterList = facilityServiceTypeMaster.selectAllServiceTypeMaster();
        List<RentTypeMaster> rentTypeMasterList = iFacilityRentTypeMaster.selectAllRentTypeMaster();
        request.setAttribute("serviceTypeMasterList", serviceTypeMasterList);
        request.setAttribute("rentTypeMasterList", rentTypeMasterList);
        int service_id = Integer.parseInt(request.getParameter("editServiceId"));

        for (Service sv: serviceList) {
            if(sv.getService_id()==service_id){
                request.setAttribute("service", sv);
                int rt = sv.getRentTypeMaster().getRenttype_id();
                int svt = sv.getServiceTypeMaster().getServicetype_id();
                request.setAttribute("rt", rt);
                request.setAttribute("svt", svt);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/edit.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        int rentprice = Integer.parseInt(request.getParameter("rentprice"));
        int maxperson = Integer.parseInt(request.getParameter("maxperson"));
        int renttype_id = Integer.parseInt(request.getParameter("renttype_id"));
        RentTypeMaster rentTypeMaster = new RentTypeMaster(renttype_id);
        int servicetype_id = Integer.parseInt(request.getParameter("servicetype_id"));
        ServiceTypeMaster serviceTypeMaster = new ServiceTypeMaster(servicetype_id);
        String standar = request.getParameter("standar");
        String other_service_description = request.getParameter("other_service_description");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String free_service = request.getParameter("free_service");
        Service service = new Service(service_id ,name, area, rentprice, maxperson, rentTypeMaster, serviceTypeMaster, standar, other_service_description, pool_area, floor, free_service);
        String mess = "Update success !";
        try {
            boolean checkDelete;
            checkDelete = facilityService.updateService(service);
            if (!checkDelete) {
                mess = "Update fail !";
            }
            request.setAttribute("mess", mess);
            listService(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response){
        int service_id = Integer.parseInt(request.getParameter("deleteServiceId"));
        boolean checkDelete = false;
        try {
            checkDelete = facilityService.deleteService(service_id);
            String mess = "Delete success !";
            if (!checkDelete) {
                mess = "Delete fail !";
            }
            request.setAttribute("message", mess);
            listService(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        int rentprice = Integer.parseInt(request.getParameter("rentprice"));
        int maxperson = Integer.parseInt(request.getParameter("maxperson"));
        int renttype_id = Integer.parseInt(request.getParameter("renttype_id"));
        RentTypeMaster rentTypeMaster = new RentTypeMaster(renttype_id);
        int servicetype_id = Integer.parseInt(request.getParameter("servicetype_id"));
        ServiceTypeMaster serviceTypeMaster = new ServiceTypeMaster(servicetype_id);
        String standar = request.getParameter("standar");
        String other_service_description = request.getParameter("other_service_description");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String free_service = request.getParameter("free_service");
        Service service = new Service(name, area, rentprice, maxperson, rentTypeMaster, serviceTypeMaster, standar, other_service_description, pool_area, floor, free_service);
        try {
            facilityService.insertService(service);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        listService(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceTypeMaster> serviceTypeMasterList = facilityServiceTypeMaster.selectAllServiceTypeMaster();
        request.setAttribute("serviceTypeMasterList", serviceTypeMasterList);
        List<RentTypeMaster> rentTypeMasterList = iFacilityRentTypeMaster.selectAllRentTypeMaster();
        request.setAttribute("rentTypeMasterList", rentTypeMasterList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = facilityService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/employee.jsp");
        dispatcher.forward(request, response);
    }
}
