package respository.contract;

import model.*;
import respository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRespository implements IContractRespository{
    private static final String DELETE_CONTRACT_SQL =
            "call sp_delete_customer(?)";
    private static final String INSERT_CONTRACT_SQL =
            "insert into contract(startdate, enddate, deposit, employee_id, customer_id, service_id) values" +
                    " (?,?,?,?,?,?);";
    private static final String INSERT_CONTRACT_DETAIL_SQL =
            "insert into contract_detail(contract_id, accompaniedservice_id, count) values" +
                    " (?,?,?,);";
    private static final String SELECT_ALL_CONTRACT =
            "select a.customer_id, a.name customername, b.type , c.contract_id, d.name servicename, c.startdate, c.enddate, \n" +
                    "ifnull(sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)+\n" +
                    "sum(f.price* e.count),sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)) as payment  , c.deposit\n" +
                    "from customer_info a join customertype_master b on a.customertype_id = b.customertype_id \n" +
                    "join contract c on a.customer_id = c.customer_id\n" +
                    "left join service d on c.service_id = d.service_id\n" +
                    "left join contract_detail e on c.contract_id = e.contract_id\n" +
                    "left join accompaniedservice_master f on e.accompaniedservice_id = f.accompaniedservice_id\n" +
                    "group by c.contract_id\n" +
                    "order by c.contract_id;";
    private static final String UPDATE_CONTRACT_SQL =
            "update customer_info set name = ?, birthday = ?, sex = ?, cardid = ?, phonenumber = ?, email = ?, address = ?, customertype_id = ? " +
                    "where customer_id = ?;";
    private static final String SELECT_ACCOMPANIEDSERVICE_BY_CONTACTID =
            "select f.accompaniedservice, f.unit, f.price ,e.count\n" +
                    "from customer_info a join customertype_master b on a.customertype_id = b.customertype_id \n" +
                    "join contract c on a.customer_id = c.customer_id\n" +
                    "left join service d on c.service_id = d.service_id\n" +
                    "left join contract_detail e on c.contract_id = e.contract_id\n" +
                    "left join accompaniedservice_master f on e.accompaniedservice_id = f.accompaniedservice_id\n" +
                    "where c.contract_id = ?;";
    @Override
    public void insertContract(Contract contract) {
        System.out.println(INSERT_CONTRACT_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)) {
            preparedStatement.setString(1, contract.getStartdate());
            preparedStatement.setString(2, contract.getEnddate());
            preparedStatement.setString(3, contract.getDeposit());
            preparedStatement.setInt(4, contract.getEmployee().getEmployee_id());
            preparedStatement.setInt(5, contract.getCustomer().getCustomer_id());
            preparedStatement.setInt(6, contract.getService().getService_id());
            System.out.println(preparedStatement);
            preparedStatement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        System.out.println(INSERT_CONTRACT_DETAIL_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)) {
            preparedStatement.setInt(1, contractDetail.getContract_id());
            preparedStatement.setInt(2, contractDetail.getAccompaniedservice_id());
            preparedStatement.setInt(3, contractDetail.getCount());
            System.out.println(preparedStatement);
            preparedStatement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int contract_id = rs.getInt("contract_id");
                String servicename = rs.getString("servicename");
                Service service = new Service(servicename);
                String customername = rs.getString("customername");
                Customer customer = new Customer(customername);
                String startdate = rs.getString("startdate");
                String enddate = rs.getString("enddate");
                String deposit = rs.getString("deposit");
                String payment = rs.getString("payment");
                PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_ACCOMPANIEDSERVICE_BY_CONTACTID);
                preparedStatement2.setInt(1, contract_id);
                ResultSet rs2 = preparedStatement2.executeQuery();
                List<Accompaniedservice> accompaniedserviceList = new ArrayList<>();
                while (rs2.next()){
                    String accompaniedservice = rs2.getString("accompaniedservice");
                    String unit = rs2.getString("unit");
                    int price = rs2.getInt("price");
                    String count = rs2.getString("count");
                    accompaniedserviceList.add( new Accompaniedservice(accompaniedservice, price, unit, count));
                }
                contractList.add(new Contract(contract_id, service, customer, startdate, enddate, deposit, payment, accompaniedserviceList));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractList;
    }

    @Override
    public boolean deleteContract(int id) {
        return false;
    }

    @Override
    public boolean updateContract(Contract contract) {
        return false;
    }

    @Override
    public List<Accompaniedservice> getContractDetailbyContractId(int contract_id) {
        List<Accompaniedservice> accompaniedserviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOMPANIEDSERVICE_BY_CONTACTID);
            preparedStatement.setInt(1, contract_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String accompaniedservice = rs.getString("accompaniedservice");
                int price = rs.getInt("price");
                String unit = rs.getString("unit");
                String count = rs.getString("count");
                accompaniedserviceList.add(new Accompaniedservice(accompaniedservice, price, unit, count));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accompaniedserviceList;
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
