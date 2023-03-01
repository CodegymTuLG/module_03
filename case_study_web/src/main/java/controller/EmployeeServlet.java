package controller;

import model.*;
import service.employee.FacilityEmployee;
import service.employee.IFacilityEmployee;
import service.levelmaster.FacilityLevelMaster;
import service.levelmaster.IFacilityLevelMaster;
import service.positionmaster.FacilityPositionMaster;
import service.positionmaster.IFacilityPositionMaster;
import service.workpartmaster.FacilityWorkPartMaster;
import service.workpartmaster.IFacilityWorkPartMaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IFacilityEmployee facilityEmployee = new FacilityEmployee();
    private IFacilityLevelMaster facilityLevelMaster = new FacilityLevelMaster();
    private IFacilityPositionMaster facilityPositionMaster = new FacilityPositionMaster();
    private IFacilityWorkPartMaster facilityWorkPartMaster = new FacilityWorkPartMaster();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertEmployee(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
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
                listEmployee(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

        List<Employee> employeeList = facilityEmployee.selectAllEmployee();
        List<PositionMaster> positionMasterList = facilityPositionMaster.selectAllPosition();
        List<LevelMaster> levelMasterList = facilityLevelMaster.selectAllLevel();
        List<WorkPartMaster> workPartMasterList = facilityWorkPartMaster.selectAllWorkPart();
        request.setAttribute("positionMasterList", positionMasterList);
        request.setAttribute("levelMasterList", levelMasterList);
        request.setAttribute("workPartMasterList", workPartMasterList);
        int editEmployeeId = Integer.parseInt(request.getParameter("editEmployeeId"));

        for (Employee ep: employeeList) {
            if(ep.getEmployee_id()==editEmployeeId){
                request.setAttribute("employee", ep);
                int pm = ep.getPositionMaster().getPosition_id();
                int lm = ep.getLevelMaster().getLevel_id();
                int wm = ep.getWorkPartMaster().getWorkpart_id();
                request.setAttribute("pm", pm);
                request.setAttribute("lm", lm);
                request.setAttribute("wm", wm);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
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

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String cardid = request.getParameter("cardid");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        PositionMaster positionMaster = new PositionMaster(position_id);
        int levelMaster_id = Integer.parseInt(request.getParameter("level_id"));
        LevelMaster levelMaster = new LevelMaster(levelMaster_id);
        int workPartMaster_id = Integer.parseInt(request.getParameter("workPart_id"));
        WorkPartMaster workPartMaster = new WorkPartMaster(workPartMaster_id);
        Employee employee = new Employee(employee_id, name, birthday, cardid, salary, phonenumber, email, address, positionMaster, levelMaster, workPartMaster);
        String mess = "Update success !";
        try {
            boolean checkDelete;
            checkDelete = facilityEmployee.updateEmployee(employee);
            if (!checkDelete) {
                mess = "Update fail !";
            }
            request.setAttribute("mess", mess);
            listEmployee(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        int employee_id = Integer.parseInt(request.getParameter("deleteEmployeeId"));
        boolean checkDelete = false;
        try {
            checkDelete = facilityEmployee.deleteEmployee(employee_id);
            String mess = "Delete success !";
            if (!checkDelete) {
                mess = "Delete fail !";
            }
            request.setAttribute("message", mess);
            listEmployee(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String cardid = request.getParameter("cardid");
        double salary = Integer.parseInt(request.getParameter("salary"));
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        PositionMaster positionMaster = new PositionMaster(position_id);
        int levelMaster_id = Integer.parseInt(request.getParameter("level_id"));
        LevelMaster levelMaster = new LevelMaster(levelMaster_id);
        int workPartMaster_id = Integer.parseInt(request.getParameter("workpart_id"));
        WorkPartMaster workPartMaster = new WorkPartMaster(workPartMaster_id);
        Employee employee = new Employee(name, birthday, cardid, salary, phonenumber, email, address, positionMaster, levelMaster, workPartMaster);
        try {
            facilityEmployee.insertEmployee(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        listEmployee(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PositionMaster> positionMasterList = facilityPositionMaster.selectAllPosition();
        request.setAttribute("positionMasterList", positionMasterList);
        List<LevelMaster> levelMasterList = facilityLevelMaster.selectAllLevel();
        request.setAttribute("levelMasterList", levelMasterList);
                List<WorkPartMaster> workPartMasterList = facilityWorkPartMaster.selectAllWorkPart();
        request.setAttribute("workPartMasterList", workPartMasterList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = facilityEmployee.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/employee.jsp");
        dispatcher.forward(request, response);
    }
}
