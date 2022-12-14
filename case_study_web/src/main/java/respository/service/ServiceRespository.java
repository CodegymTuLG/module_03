package respository.service;

import model.Service;
import respository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRespository implements IServiceRespository {
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service(name, area, rentprice, maxperson, renttype_id, servicetype_id, standar, other_service_description, pool_area, floor, free_service) VALUES " +
                    " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_SERVICE =
            "select s.service_id, s.name, s.area, s.rentprice, s.maxperson, rm.type renttype, sm.type servicetype, s.standar, s.other_service_description, s.pool_area, s.floor, s.free_service from service s" +
                    " join renttype_master rm on s.renttype_id = rm.renttype_id" +
                    " join servicetype_master sm on s.servicetype_id = sm.servicetype_id" +
                    " order by s.service_id asc ";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public ServiceRespository() {
    }

    @Override
    public void insertService(Service service) {
        System.out.println(INSERT_SERVICE_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setInt(3, service.getRentprice());
            preparedStatement.setInt(4, service.getMaxperson());
            preparedStatement.setInt(5, service.getRenttype_id());
            preparedStatement.setInt(6, service.getServicetype_id());
            preparedStatement.setString(7, service.getStandar());
            preparedStatement.setString(8, service.getOther_service_description());
            preparedStatement.setDouble(9, service.getPool_area());
            preparedStatement.setInt(10, service.getFloor());
            preparedStatement.setString(11, service.getFree_service());
            System.out.println(preparedStatement);
            preparedStatement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Service selectService(int id) {
        return null;
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int service_id = rs.getInt("service_id");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                int rentprice = rs.getInt("rentprice");
                int maxperson = rs.getInt("maxperson");
                String renttype = rs.getString("renttype");
                String servicetype = rs.getString("servicetype");
                String standar = rs.getString("standar");
                String other_service_description = rs.getString("other_service_description");
                double pool_area = rs.getDouble("pool_area");
                int floor = rs.getInt("floor");
                String free_service = rs.getString("free_service");
                serviceList.add(new Service(service_id, name, area, rentprice, maxperson, renttype, servicetype, standar, other_service_description, pool_area, floor, free_service));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return false;
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
