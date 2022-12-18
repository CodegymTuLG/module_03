package dao.service;

import model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/furamaproject?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" +
            "(name, area, rentprice, maxperson, renttype_id, servicetype_id, standar, other_service_description, pool_area, floor, free_service) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public ServiceDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertService(Service service) throws SQLException {
        System.out.println(INSERT_SERVICE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            //(name, area, rentprice, maxperson, renttype_id, servicetype_id, standar, other_service_description, pool_area, floor, free_service)
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2,  service.getArea());
            preparedStatement.setInt(3, service.getRentprice());
            preparedStatement.setInt(4, service.getMaxperson());
            preparedStatement.setInt(5, service.getRenttype_id());
            preparedStatement.setInt(6, service.getService_id());
            preparedStatement.setString(7, service.getStandar());
            preparedStatement.setString(8, service.getOther_service_description());
            preparedStatement.setDouble(9, service.getPool_area());
            preparedStatement.setInt(10, service.getFloor());
            preparedStatement.setString(11, service.getFree_service());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Service selectService(int id) {
        return null;
    }

    @Override
    public List<Service> selectAllService() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Service> serviceList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int service_id = rs.getInt("service_id");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                int rentprice = rs.getInt("rentprice");
                int maxperson = rs.getInt("maxperson");
                int renttype_id = rs.getInt("renttype_id");
                int servicetype_id = rs.getInt("servicetype_id");
                String standar = rs.getString("standar");
                String other_service_description = rs.getString("other_service_description");
                double pool_area = rs.getDouble("pool_area");
                int floor = rs.getInt("floor");
                String free_service = rs.getString("free_service");
                serviceList.add(new Service(service_id, name, area, rentprice, maxperson, renttype_id, servicetype_id, standar, other_service_description, pool_area, floor, free_service));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return false;
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
