package pl.sda.controller;

import pl.sda.service.BasketService;
import pl.sda.service.BasketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFromBasket")
public class DeleteFromBasketController extends HttpServlet {
    private final BasketService basketService = new BasketServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        basketService.deleteProduct(req,id);

        resp.sendRedirect("/basket");
    }
}
