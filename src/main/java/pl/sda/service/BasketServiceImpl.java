package pl.sda.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class BasketServiceImpl implements BasketService {

    @Override
    public void addProduct(HttpServletRequest req, Long productId) {
        HttpSession session = req.getSession();
        ArrayList<Long> phonesIdsList = (ArrayList<Long>) session.getAttribute("phonesInCart");
        if (phonesIdsList == null){
            phonesIdsList = new ArrayList<Long>();
        }
        phonesIdsList.add(productId);
        session.setAttribute("phonesInCart", phonesIdsList);
    }

    @Override
    public void deleteProduct(HttpServletRequest req, Long productId) {
        HttpSession session = req.getSession();
        ArrayList<Long> phonesIdsList = (ArrayList<Long>) session.getAttribute("phonesInCart");
        phonesIdsList.remove(productId);
        session.setAttribute("phonesInCart", phonesIdsList);
    }

    @Override
    public List<Long> getProductsId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (ArrayList<Long>) session.getAttribute("phonesInCart");
    }

    @Override
    public void cleanBucket(HttpServletRequest request) {
        if (request.getSession().getAttribute("phonesInCart") != null){
            ((List<Long>) request.getSession().getAttribute("phonesInCart")).clear();
        }
    }
}
