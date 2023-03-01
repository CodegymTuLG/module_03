package respository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRespository {
    public void insertProduct(Product product) throws SQLException;

    public List<Product> selectAllProduct();

    public List<Product> search(int count);
}
