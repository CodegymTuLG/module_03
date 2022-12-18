package dao.servicetypemaster;

import model.Service;
import model.ServiceTypeMaster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeMasterDAO implements IServiceTypeMasterDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/furamaproject?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String SELECT_ALL_SERVICETYPEMASTER = "select * from servicetype_master";

    public ServiceTypeMasterDAO() {
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
    public List<ServiceTypeMaster> selectAllServiceTypeMaster() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<ServiceTypeMaster> serviceTypeMasters = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICETYPEMASTER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int servicetype_id = rs.getInt("servicetype_id");
                String type = rs.getString("type");
                serviceTypeMasters.add(new ServiceTypeMaster(servicetype_id, type));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceTypeMasters;
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
