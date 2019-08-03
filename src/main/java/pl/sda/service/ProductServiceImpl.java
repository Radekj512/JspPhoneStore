package pl.sda.service;

import pl.sda.dao.ProductDao;
import pl.sda.dao.ProductDaoImpl;
import pl.sda.dao.ProductImageDao;
import pl.sda.dao.ProductImageDaoImpl;
import pl.sda.entity.ProductEntity;
import pl.sda.model.Brand;
import pl.sda.model.Product;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static pl.sda.mapper.ProductMapper.mapToProduct;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao = new ProductDaoImpl();
    private final ProductImageDao productImageDao = new ProductImageDaoImpl();

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts().stream()
                .map(p -> mapToProduct(p, productImageDao.getImagePathForProduct(p.getId()))).collect(Collectors.toList());
    }

    @Override
    public Product getProduct(long id) {
        ProductEntity productEntity = productDao.getProduct(id).orElse(null);
        String imagePathForProduct = productImageDao.getImagePathForProduct(id);
        return mapToProduct(productEntity, imagePathForProduct);
    }

    @Override
    public List<Product> getProductsByBrand(List<Brand> brandList) {
        return getProducts().stream().filter(p -> brandList.contains(p.getBrand())).collect(Collectors.toList());
    }
}
