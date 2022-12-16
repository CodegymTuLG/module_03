package respository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRespository implements IProductRespository {
    private static List<Product> productList = new ArrayList<>();
    private static List<Product> searchResult = new ArrayList<>();
    static{
        productList.add(new Product(1,"Iphone","China"));
        productList.add(new Product(2,"Bphone","VN"));
        productList.add(new Product(3,"Samsung","Korea"));
        productList.add(new Product(4,"Docomo","JP"));
        productList.add(new Product(5,"Docomo1","JP1"));
    }
    @Override
    public List<Product> showList() {
        return productList;
    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        return false;
    }

    @Override
    public boolean editProduct(Product product) {
        for (Product pd:productList) {
            if(product.getId() == pd.getId()){
                int index = productList.indexOf(pd);
                productList.set(index, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> deleteProduct(int id) {
        for (Product pd:productList) {
            if(id == pd.getId()){
                productList.remove(pd);
                return productList;
            }
        }
        return null;
    }

    @Override
    public Product viewDetail(int id) {
        for (Product pd:productList) {
            if(id == pd.getId()){
                return pd;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        if(name.trim().equals("")){
            return productList;
        }
        for (Product product: productList) {
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                searchResult.add(product);
            }
        }
        return searchResult;
    }

    @Override
    public Product findById(int id) {
        for (Product product: productList) {
            if(id == product.getId()){
                return product;
            }
        }
        return null;
    }
}
