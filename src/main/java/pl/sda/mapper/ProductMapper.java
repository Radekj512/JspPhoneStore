package pl.sda.mapper;

import pl.sda.entity.ProductEntity;
import pl.sda.model.Product;

public class ProductMapper {
    public static Product mapToProduct(ProductEntity productEntity, String imagePathForProduct) {
        return Product.builder()
                .id(productEntity.getId())
                .brand(productEntity.getBrand())
                .model(productEntity.getModel())
                .operatingSystem(productEntity.getOperatingSystem())
                .price(productEntity.getSellingPrice())
                .primaryCameraMp(productEntity.getPrimaryCameraMp())
                .secondaryCameraMp(productEntity.getSecondaryCameraMp())
                .imagePath(imagePathForProduct)
                .build();
    }
}
