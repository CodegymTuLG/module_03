package respository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRespository implements IProductRespository {
    private static final String INSERT_PRODUCT_SQL =
            "insert into product(productName, price, discount, stock) values" +
                    " (?,?,?,?);";
    private static final String SELECT_ALL_PRODUCT =
            "select * from product;";
    private static final String SEARCH = "select p.*, count(contractId) as count from product p join contract c on c.productId = p.productId group by productId limit ? ; ";

    public ProductRespository() {
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getDiscount());
            preparedStatement.setInt(4, product.getStock());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                int stock = rs.getInt("stock");
                productList.add(new Product(productId, productName, price, discount, stock));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public List<Product> search(int count) {
        List<Product> productList = new ArrayList<>();
        Connection  connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setInt(1, count);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                int stock = rs.getInt("stock");
                productList.add(new Product(productId, productName, price, discount, stock));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
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
