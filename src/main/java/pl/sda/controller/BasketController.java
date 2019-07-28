package pl.sda.controller;

import pl.sda.model.Product;
import pl.sda.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/basket")
public class BasketController extends HttpServlet {

    private final BasketService basketService = new BasketServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> ids = basketService.getProductsId(req);
        List<Product> phonesInBasket = new ArrayList<>();
        if (ids != null) {
            ids.forEach(id -> phonesInBasket.add(productService.getProduct(id)));
        }
        BigDecimal totalPrice = billService.getFinalBill(phonesInBasket);
        req.setAttribute("phones", phonesInBasket);
        req.setAttribute("total", totalPrice);


        req.getRequestDispatcher("/WEB-INF/view/basket.jsp").forward(req, resp);
    }
}
