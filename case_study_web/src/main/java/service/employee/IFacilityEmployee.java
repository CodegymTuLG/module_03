package service.employee;

import model.Employee;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityEmployee {
    public void insertEmployee(Employee employee) throws SQLException;

    public List<Employee> selectAllEmployee();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
}
