package respository.levelmaster;

import model.LevelMaster;
import model.PositionMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelMasterRespository implements ILevelMasterRespository {
    private static final String SELECT_ALL_LEVEL = "select * from level_master";

    public LevelMasterRespository() {
    }

    @Override
    public List<LevelMaster> selectAllLevel() {

        List<LevelMaster> levelMasters = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LEVEL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int level_id = rs.getInt("level_id");
                String level = rs.getString("level");
                levelMasters.add(new LevelMaster(level_id, level));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return levelMasters;
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
