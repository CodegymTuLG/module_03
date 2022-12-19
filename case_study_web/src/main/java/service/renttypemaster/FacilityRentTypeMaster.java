package service.renttypemaster;

import model.RentTypeMaster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRentTypeMaster implements IFacilityRentTypeMaster {

    @Override
    public List<RentTypeMaster> selectAllRentTypeMaster() {

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
