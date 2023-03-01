package respository.workpartmaster;

import model.WorkPartMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkPartMasterRespository implements IWorkPartMasterRespository {
    private static final String SELECT_ALL_WORKPARTMASTER = "select * from workpart_master";

    public WorkPartMasterRespository() {
    }

    @Override
    public List<WorkPartMaster> selectAllWorkPart() {

        List<WorkPartMaster> workPartMasters = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WORKPARTMASTER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int workpart_id = rs.getInt("workpart_id");
                String workpart = rs.getString("workpart");
                workPartMasters.add(new WorkPartMaster(workpart_id, workpart));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return workPartMasters;
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
