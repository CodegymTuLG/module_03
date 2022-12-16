package service;

import model.Product;
import respository.IProductRespository;
import respository.ProductRespository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
private IProductRespository productRespository = new ProductRespository();
    @Override
    public List<Product> showList() {
        return productRespository.showList();
    }

    @Override
    public boolean addProduct(Product product) {
        return productRespository.addProduct(product);
    }

    @Override
    public boolean editProduct(Product product) {
        productRespository.editProduct(product);
        return false;
    }

    @Override
    public List<Product> deleteProduct(int id) {
        return productRespository.deleteProduct(id);
    }

    @Override
    public Product viewDetail(int id) {
        return productRespository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRespository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return productRespository.findById(id);
    }
}
