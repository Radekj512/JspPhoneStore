package pl.sda.controller;

import pl.sda.service.ProductService;
import pl.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produkt")
public class ShowProductController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productService.getProduct(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req,resp);
    }
}
