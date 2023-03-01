package respository.customer;

import model.*;
import respository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRespository implements ICustomerRespository{
    private static final String DELETE_CUSTOMER_SQL =
            "call sp_delete_customer(?)";
    private static final String INSERT_CUSTOMER_SQL =
            "insert into customer_info(customertype_id, name, birthday, sex, cardid, phonenumber, email, address) values" +
                    " (?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CUSTOMER =
            "select ci.*, ct.type from customer_info ci \n" +
                    "join customertype_master ct on ci.customertype_id = ct.customertype_id\n" +
                    "order by ci.customer_id asc;";
    private static final String UPDATE_CUSTOMER_SQL =
            "update customer_info set name = ?, birthday = ?, sex = ?, cardid = ?, phonenumber = ?, email = ?, address = ?, customertype_id = ? " +
                    "where customer_id = ?;";
    private static final String SEARCH = "select ci.*, ct.type from customer_info ci \n" +
            "join customertype_master ct on ci.customertype_id = ct.customertype_id\n" +
            "where ci.name like ? and ci.address like ? and ct.type like ? \n" +
            "order by ci.customer_id asc;";
    public CustomerRespository() {
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeMaster().getCustomertype_id());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getSex());
            preparedStatement.setString(5, customer.getCardid());
            preparedStatement.setString(6, customer.getPhonenumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                int customertype_id = rs.getInt("customertype_id");
                String type = rs.getString("type");
                CustomerTypeMaster customerTypeMaster = new CustomerTypeMaster(customertype_id, type);
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                int sex = rs.getInt("sex");
                String cardid = rs.getString("cardid");
                String phonenumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customerList.add(new Customer(customer_id, customerTypeMaster, name, birthday, sex, cardid, phonenumber, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_CUSTOMER_SQL);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getBirthday());
            statement.setInt(3, customer.getSex());
            statement.setString(4, customer.getCardid());
            statement.setString(5, customer.getPhonenumber());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setInt(8, customer.getCustomerTypeMaster().getCustomertype_id());
            statement.setInt(9, customer.getCustomer_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> search(String nameSearch, String searchAddress, String searchType) {
        List<Customer> customerList = new ArrayList<>();
        Connection  connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+nameSearch+"%");
            preparedStatement.setString(2,"%"+searchAddress+"%");
            preparedStatement.setString(3,"%"+searchType+"%");
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int customer_id = rs.getInt("customer_id");
                int customertype_id = rs.getInt("customertype_id");
                String type = rs.getString("type");
                CustomerTypeMaster customerTypeMaster = new CustomerTypeMaster(customertype_id, type);
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                int sex = rs.getInt("sex");
                String cardid = rs.getString("cardid");
                String phonenumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customerList.add(new Customer(customer_id, customerTypeMaster, name, birthday, sex, cardid, phonenumber, email, address));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
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
