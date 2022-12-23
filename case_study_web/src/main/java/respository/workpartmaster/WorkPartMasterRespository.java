package respository.workpartmaster;

import model.RentTypeMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeMasterRespository implements IRentTypeMasterRespository {
    private static final String SELECT_ALL_RENTTYPEMASTER = "select * from renttype_master";

    public RentTypeMasterRespository() {
    }

    @Override
    public List<RentTypeMaster> selectAllRentTypeMaster() {

        List<RentTypeMaster> rentTypeMasters = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENTTYPEMASTER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int renttype_id = rs.getInt("renttype_id");
                String type = rs.getString("type");
                rentTypeMasters.add(new RentTypeMaster(renttype_id, type));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentTypeMasters;
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
