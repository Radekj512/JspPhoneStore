package pl.sda.service;

import pl.sda.model.Brand;
import pl.sda.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(long id);
    List<Product> getProductsByBrand(List<Brand> brandList);
}
