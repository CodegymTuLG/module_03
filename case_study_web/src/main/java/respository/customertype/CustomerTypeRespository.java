package respository.customertype;

import model.CustomerTypeMaster;
import model.LevelMaster;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRespository implements ICustomerTypeRespository {
    private static final String SELECT_ALL_CUSTOMERTYPE = "select * from customertype_master";

    public CustomerTypeRespository() {
    }

    @Override
    public List<CustomerTypeMaster> selectAllCustomerType() {

        List<CustomerTypeMaster> customerTypeMasters = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customertype_id = rs.getInt("customertype_id");
                String type = rs.getString("type");
                customerTypeMasters.add(new CustomerTypeMaster(customertype_id, type));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerTypeMasters;
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
