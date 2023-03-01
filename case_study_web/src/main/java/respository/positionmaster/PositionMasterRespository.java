package respository.positionmaster;

import model.PositionMaster;
import model.RentTypeMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionMasterRespository implements IPositionMasterRespository {
    private static final String SELECT_ALL_POSITIONMASTER = "select * from position_master";

    public PositionMasterRespository() {
    }

    @Override
    public List<PositionMaster> selectAllPosition() {

        List<PositionMaster> positionMasters = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITIONMASTER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int position_id = rs.getInt("position_id");
                String position = rs.getString("position");
                positionMasters.add(new PositionMaster(position_id, position));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return positionMasters;
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
