package controller;

import model.*;
import service.customer.FacilityCustomer;
import service.customer.IFacilityCustomer;
import service.customertypemaster.FacilityCustomerTypeMaster;
import service.customertypemaster.IFacilityCustomerTypeMaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IFacilityCustomer facilityCustomer = new FacilityCustomer();
    private IFacilityCustomerTypeMaster facilityCustomerTypeMaster = new FacilityCustomerTypeMaster();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                listCustomer(request, response);
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
                listCustomer(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchAddress = request.getParameter("searchAddress");
        String searchType = request.getParameter("searchType");
        request.setAttribute("searchName",searchName);
        request.setAttribute("searchAddress",searchAddress);
        request.setAttribute("searchType",searchType);
        List<Customer> customerList = facilityCustomer.search(searchName,searchAddress,searchType);
        request.setAttribute("customerList", customerList);
        List<CustomerTypeMaster> customerTypeMasters = facilityCustomerTypeMaster.selectAllCustomerType();
        request.setAttribute("customerTypeMasters", customerTypeMasters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = facilityCustomer.selectAllCustomer();
        List<CustomerTypeMaster> customerTypeMasters = facilityCustomerTypeMaster.selectAllCustomerType();
        request.setAttribute("customerTypeMasters", customerTypeMasters);
        int editCustomerId = Integer.parseInt(request.getParameter("editCustomerId"));
        for (Customer c : customerList) {
            if (c.getCustomer_id() == editCustomerId) {
                request.setAttribute("customer", c);
                int ct = c.getCustomerTypeMaster().getCustomertype_id();
                request.setAttribute("ct", ct);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/edit.jsp");
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

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String cardid = request.getParameter("cardid");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerType_id = Integer.parseInt(request.getParameter("customertype_id"));
        CustomerTypeMaster customerTypeMaster = new CustomerTypeMaster(customerType_id);
        Customer customer = new Customer(customer_id, customerTypeMaster, name, birthday, sex, cardid, phonenumber, email, address);
        String mess = "Update success !";
        try {
            boolean checkDelete;
            checkDelete = facilityCustomer.updateCustomer(customer);
            if (!checkDelete) {
                mess = "Update fail !";
            }
            request.setAttribute("mess", mess);
            listCustomer(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_id = Integer.parseInt(request.getParameter("deleteCustomerId"));
        boolean checkDelete = false;
        try {
            checkDelete = facilityCustomer.deleteCustomer(customer_id);
            String mess = "Delete success !";
            if (!checkDelete) {
                mess = "Delete fail !";
            }
            request.setAttribute("message", mess);
            listCustomer(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String cardid = request.getParameter("cardid");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerType_id = Integer.parseInt(request.getParameter("customertype_id"));
        CustomerTypeMaster customerTypeMaster = new CustomerTypeMaster(customerType_id);
        Customer customer = new Customer(customerTypeMaster, name, birthday, sex, cardid, phonenumber, email, address);
        try {
            facilityCustomer.insertCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        listCustomer(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerTypeMaster> customerTypeMasters = facilityCustomerTypeMaster.selectAllCustomerType();
        request.setAttribute("customerTypeMasters", customerTypeMasters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = facilityCustomer.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        List<CustomerTypeMaster> customerTypeMasters = facilityCustomerTypeMaster.selectAllCustomerType();
        request.setAttribute("customerTypeMasters", customerTypeMasters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/customer.jsp");
        dispatcher.forward(request, response);
    }
}
