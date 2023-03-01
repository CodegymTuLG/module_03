package respository.employee;

import model.*;
import respository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRespository implements IEmployeeRespository {
    private static final String DELETE_EMPLOYEE_SQL =
            "call sp_delete_employee_info(?)";
    private static final String INSERT_EMPLOYEE_SQL =
            "insert into employee_info(name, birthday, cardid, salary, phonenumber, email, address, position_id, level_id, workpart_id) values" +
                    " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_EMPLOYEE =
            "select em.*, pm.position, lm.level, wm.workpart from employee_info em \n" +
                    "join position_master pm on pm.position_id = em.position_id\n" +
                    "join level_master lm on lm.level_id = em.level_id\n" +
                    "join workpart_master wm on wm.workpart_id = em.workpart_id\n" +
                    "order by employee_id asc";
        private static final String UPDATE_EMPLOYEE_SQL =
            "update employee_info set name = ?, birthday = ?, cardid = ?, salary = ?, phonenumber = ?, email = ?, address = ?, position_id = ?, level_id = ?, workpart_id = ?\n" +
                    "where employee_id = ?";

    public EmployeeRespository() {
    }

    @Override
    public void insertEmployee(Employee employee) {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getCardid());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhonenumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionMaster().getPosition_id());
            preparedStatement.setInt(9, employee.getLevelMaster().getLevel_id());
            preparedStatement.setInt(10, employee.getWorkPartMaster().getWorkpart_id());
            System.out.println(preparedStatement);
            preparedStatement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeelist = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employee_id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String cardid = rs.getString("cardid");
                double salary = rs.getInt("salary");
                String phonenumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int position_id = rs.getInt("position_id");
                String position = rs.getString("position");
                int level_id = rs.getInt("level_id");
                String level = rs.getString("level");
                int workpart_id = rs.getInt("workpart_id");
                String workpart = rs.getString("workpart");
                PositionMaster positionMaster = new PositionMaster(position_id, position);
                LevelMaster levelMaster = new LevelMaster(level_id, level);
                WorkPartMaster workPartMaster = new WorkPartMaster(workpart_id,workpart);
                employeelist.add(new Employee(employee_id, name, birthday, cardid, salary, phonenumber, email, address, positionMaster, levelMaster, workPartMaster));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeelist;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_EMPLOYEE_SQL);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getBirthday());
            statement.setString(3, employee.getCardid());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhonenumber());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPositionMaster().getPosition_id());
            statement.setInt(9, employee.getLevelMaster().getLevel_id());
            statement.setInt(10, employee.getWorkPartMaster().getWorkpart_id());
            statement.setInt(11, employee.getEmployee_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
