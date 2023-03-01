package respository.accompaniedservice;

import model.Accompaniedservice;
import model.LevelMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccompaniedserviceRespository implements IAccompaniedserviceRespository{
    private static final String SELECT_ALL_ACCOMPANIEDSERVICE = "select * from accompaniedservice_master";
    private static final String SELECT_ALL_ACCOMPANIEDSERVICE_BY_SERVICE_ID = "select f.accompaniedservice, f.unit, f.price ,e.count\n" +
            "from customer_info a join customertype_master b on a.customertype_id = b.customertype_id \n" +
            "join contract c on a.customer_id = c.customer_id\n" +
            "left join service d on c.service_id = d.service_id\n" +
            "left join contract_detail e on c.contract_id = e.contract_id\n" +
            "left join accompaniedservice_master f on e.accompaniedservice_id = f.accompaniedservice_id\n" +
            "where c.contract_id = ?";
    @Override
    public List<Accompaniedservice> showListAccompaniedservice() {
        List<Accompaniedservice> accompaniedservices = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOMPANIEDSERVICE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int accompaniedservice_id = rs.getInt("accompaniedservice_id");
                String accompaniedservice = rs.getString("accompaniedservice");
                int price = rs.getInt("price");
                String unit = rs.getString("unit");
                String status = rs.getString("status");
                accompaniedservices.add(new Accompaniedservice(accompaniedservice_id, accompaniedservice, price, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return accompaniedservices;
    }

    @Override
    public List<Accompaniedservice> showListAccompaniedserviceByContractId(int id) {
        List<Accompaniedservice> accompaniedservices = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOMPANIEDSERVICE_BY_SERVICE_ID);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int accompaniedservice_id = rs.getInt("accompaniedservice_id");
                String accompaniedservice = rs.getString("accompaniedservice");
                int price = rs.getInt("price");
                String unit = rs.getString("unit");
                String status = rs.getString("status");
                accompaniedservices.add(new Accompaniedservice(accompaniedservice_id, accompaniedservice, price, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return accompaniedservices;
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
