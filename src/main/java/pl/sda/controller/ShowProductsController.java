package pl.sda.controller;

import pl.sda.model.Brand;
import pl.sda.service.ProductService;
import pl.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/produkty")
public class ShowProductsController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> filteredBrands = getBrands(req);

        req.setAttribute("brands", Brand.values());

        if (filteredBrands.size() != 0) {
            req.setAttribute("products", productService.getProductsByBrand(filteredBrands));
            req.setAttribute("checkedBrands", filteredBrands);
            req.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(req, resp);
        } else {

            req.setAttribute("products", productService.getProducts());
            req.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(req, resp);
        }
    }

    private List<Brand> getBrands(HttpServletRequest req) {
        String[] brands = req.getParameterValues("marka");
        return brands == null ? new ArrayList<>() : Arrays.asList(brands).stream().map(b -> Brand.valueOf(b)).collect(Collectors.toList());
    }
}
