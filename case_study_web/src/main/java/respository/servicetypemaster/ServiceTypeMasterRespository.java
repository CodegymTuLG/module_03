package respository.servicetypemaster;

import model.ServiceTypeMaster;
import respository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeMasterRespository implements IServiceTypeMasterRespository {
    private static final String SELECT_ALL_SERVICETYPEMASTER = "select * from servicetype_master";

    public ServiceTypeMasterRespository() {
    }

    @Override
    public List<ServiceTypeMaster> selectAllServiceTypeMaster() {
        List<ServiceTypeMaster> serviceTypeMasters = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICETYPEMASTER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
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
