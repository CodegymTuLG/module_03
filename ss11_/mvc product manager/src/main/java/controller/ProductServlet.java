package controller;

import model.Product;
import respository.IProductRespository;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/home")
public class ProductServlet extends HttpServlet {
    private IProductService productService= new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addnew(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                break;
            case "view-detail":
                break;
            case "searchByName":
                searchByName(request,response);
                break;
            default:
                showListProduct(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showFormAdd(request,response);
                break;
            case "edit":
                break;
            case "delete":
                delete(request,response);
                break;
            case "detail":
                viewDetail(request,response);
                break;
            case "search":
                searchById(request,response);
                break;
            case "searchByName":
                searchByName(request,response);
                break;
            default:
                showListProduct(request,response);
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.viewDetail(id);
        request.setAttribute("product",product);
        showFormDetail(request,response);
    }

    private void showFormDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/detail.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searching");
        List<Product> productList = productService.findByName(name);
        String message = "";
        if (productList.size() == 0) {
            message = "no have match record!";
        }
        request.setAttribute("productList",productList);
        request.setAttribute("message",message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        productList.clear();
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.deleteProduct(id);
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        showFormEdit(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =  request.getParameter("name");
        String marker =  request.getParameter("marker");
        Product newProduct = new Product(id,name,marker);
        productService.editProduct(newProduct);
        showListProduct(request,response);
    }

    private void addnew(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =  request.getParameter("name");
        String marker =  request.getParameter("marker");
        Product newProduct = new Product(id,name,marker);
        productService.addProduct(newProduct);
        showFormAdd(request,response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
    List<Product> productList = productService.showList();
    request.setAttribute("productList",productList);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
