package pl.sda.dao;

import pl.sda.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<ProductEntity> getProducts();
    Optional<ProductEntity> getProduct(long id);
}
