package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double fistOperand = Integer.parseInt(request.getParameter("fistOperand"));
        double secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        String operand = request.getParameter("operand");
        double result = 0;
        String mess = "";
        switch (operand){
            case "+":
                result = fistOperand+secondOperand;
                break;
            case "-":
                result = fistOperand-secondOperand;
                break;
            case "*":
                result = fistOperand*secondOperand;
                break;
            case "/":
                try{
                    if(secondOperand == 0){
                        result = 0;
                        mess = "On this operator second Operand cant be ZERO";
                        request.setAttribute("mess",mess);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calculator.jsp");
                        try {
                            requestDispatcher.forward(request,response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        result = fistOperand/secondOperand;
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                break;
        }
        request.setAttribute("fistOperand",fistOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operand",operand);
        request.setAttribute("result",result);
        request.setAttribute("mess",mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calculator.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
