package service.employee;

import model.Employee;
import model.Service;
import respository.employee.EmployeeRespository;
import respository.employee.IEmployeeRespository;
import respository.service.IServiceRespository;
import respository.service.ServiceRespository;

import java.sql.SQLException;
import java.util.List;

public class FacilityEmployee implements IFacilityEmployee {
    IEmployeeRespository employeeRespository = new EmployeeRespository();
    @Override
    public void insertEmployee(Employee service) throws SQLException {
        employeeRespository.insertEmployee(service);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRespository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRespository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRespository.updateEmployee(employee);
    }
}
