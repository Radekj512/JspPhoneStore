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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/buy")
public class BuyController extends HttpServlet {
   private BasketService basketService = new BasketServiceImpl();
   private ProductService productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> ids = basketService.getProductsId(req);
        List<Product> phonesToBuy = new ArrayList<>();
        if (ids != null) {
            ids.forEach(id -> phonesToBuy.add(productService.getProduct(id)));
        }
        phonesToBuy.forEach(p-> System.out.println("Kupiono "+p.getBrand()+" " + p.getModel()));
        basketService.cleanBucket(req);
        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req,resp);
    }
}
