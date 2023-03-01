package service;

import model.Product;
import respository.ProductRespository;
import respository.IProductRespository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
IProductRespository productRespository = new ProductRespository();
    @Override
    public void insertProduct(Product product) throws SQLException {
        productRespository.insertProduct(product);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRespository.selectAllProduct();
    }

    @Override
    public List<Product> search(int count) {
        return productRespository.search(count);
    }
}
