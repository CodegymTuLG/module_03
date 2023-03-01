package controller;

import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import model.*;
import respository.accompaniedservice.AccompaniedserviceRespository;
import respository.accompaniedservice.IAccompaniedserviceRespository;
import respository.employee.IEmployeeRespository;
import service.accompaniedservice.FacilityAccompaniedservice;
import service.accompaniedservice.IFacilityAccompaniedservice;
import service.contract.FacilityContract;
import service.contract.IFacilityContract;
import service.customer.FacilityCustomer;
import service.customer.IFacilityCustomer;
import service.customertypemaster.FacilityCustomerTypeMaster;
import service.customertypemaster.IFacilityCustomerTypeMaster;
import service.employee.FacilityEmployee;
import service.employee.IFacilityEmployee;
import service.service.FacilityService;
import service.service.IFacilityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IFacilityContract facilityContract = new FacilityContract();
    private IFacilityAccompaniedservice facilityAccompaniedservice = new FacilityAccompaniedservice();
    private IFacilityCustomer facilityCustomer = new FacilityCustomer();
    private IFacilityService facilityService = new FacilityService();
    private IFacilityEmployee facilityEmployee = new FacilityEmployee();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addaccompaniedservice":
                addAccompaniedService(request, response);
                break;
            case "createContract":
                createNewContract(request, response);
                break;
            case "contractDetail":
                getContractDetail(request, response);
                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
        }
    }

    private void getContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        List<Accompaniedservice> listContractDetail = facilityContract.getContractDetailbyContractId(contract_id);
        int listContractDetailSize = listContractDetail.size();
        request.setAttribute("listContractDetailSize",listContractDetailSize);
        request.setAttribute("listContractDetail",listContractDetail);
        request.setAttribute("flag",1);
        listContract(request,response);
    }

    private void createNewContract(HttpServletRequest request, HttpServletResponse response) {
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String deposit = request.getParameter("deposit");
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = new Employee(employee_id);
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = new Customer(customer_id);
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Service service = new Service(service_id);
        Contract contract = new Contract(service , customer, employee, startdate, enddate, deposit);
        String subService = request.getParameter("subServices");
        String[] subsIds = subService.split(",");
  /*      List<ContractDetail> contractDetail = new ArrayList<>();
        List<Accompaniedservice> accompaniedserviceList = facilityAccompaniedservice.showListAccompaniedservice();
        int x = (int) Array.get(subsIds, 0);
        List countSubs = new ArrayList();
        List subs = new ArrayList();
        subs.add(x);
        countSubs.add(1);
        for (int i = 0; i < subs.size(); i++) {
                for (int j = 1; j < subsIds.length; j++) {
                    if(subs.get(i) == subsIds[j]){
                        countSubs.set(i, Integer.parseInt((String) countSubs.get(i))+1);
                        contractDetail.remove(j);
                    }
                }
            }*/

/*        for (Accompaniedservice ac: accompaniedserviceList) {
            contractDetail.add( new ContractDetail(service_id, ac.getAccompaniedservice_id(), 0));
        }
        for (int i = 0; i < contractDetail.size(); i++) {
            int count = 0;
            for (int j = 0; j < subsIds.length; j++) {
                if(Integer.parseInt(subsIds[j]) == contractDetail.get(i).getAccompaniedservice_id()){
                    count++;
                    continue;
                }
                contractDetail.set(i,new ContractDetail(i+1,service_id,count));
            }
        }*/
        facilityContract.insertContract(contract);
        listContract(request, response);
    }

    private void addAccompaniedService(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showNewForm(request, response);
//                break;
            default:
                listContract(request, response);
                break;
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = facilityContract.selectAllContract();
        request.setAttribute("contractList", contractList);
        List<Accompaniedservice> accompaniedserviceListOfContract = new ArrayList<>();
        for (Contract c: contractList) {
            accompaniedserviceListOfContract = c.getAccompaniedserviceList();
        }
        request.setAttribute("accompaniedserviceListOfContract", accompaniedserviceListOfContract);
        List<Accompaniedservice> accompaniedserviceList = facilityAccompaniedservice.showListAccompaniedservice();
        request.setAttribute("accompaniedserviceList", accompaniedserviceList);
        List<Customer> customerList = facilityCustomer.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        List<Service> serviceList = facilityService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        List<Employee> employeeList = facilityEmployee.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/contract/contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
