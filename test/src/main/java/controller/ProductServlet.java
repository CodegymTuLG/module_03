package controller;

import model.Product;
import service.ProductService;
import service.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                createNew(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }


    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Product product = new Product(productName, price, discount, stock);
        try {
            productService.insertProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        listProduct(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        int recordNum = Integer.parseInt(request.getParameter("recordNum"));
        List<Product> productList = productService.search(recordNum);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
