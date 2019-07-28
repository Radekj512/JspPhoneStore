package pl.sda.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BasketService {
    void addProduct(HttpServletRequest req, Long productId);

    void deleteProduct(HttpServletRequest req, Long productId);

    List<Long> getProductsId(HttpServletRequest request);

    void cleanBucket(HttpServletRequest request);
}
