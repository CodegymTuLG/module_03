package respository;

import model.Product;

import java.util.List;

public interface IProductRespository {
    List<Product> showList();
    boolean addProduct(Product product);
    boolean editProduct(Product product);
    List<Product> deleteProduct(int id);
    Product viewDetail(int id);
    List<Product> findByName(String name);
    Product findById(int id);
}
