package pl.sda.controller;

import pl.sda.model.Product;
import pl.sda.service.BasketService;
import pl.sda.service.BasketServiceImpl;
import pl.sda.service.ProductService;
import pl.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyNow")
public class BuyNowController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private BasketService basketService = new BasketServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Product product = productService.getProduct(id);
        basketService.cleanBucket(req);
        basketService.addProduct(req,id);
        basketService.cleanBucket(req);
        req.setAttribute("phone", product);
        req.getRequestDispatcher("/WEB-INF/view/buyNow.jsp").forward(req,resp);
    }
}
