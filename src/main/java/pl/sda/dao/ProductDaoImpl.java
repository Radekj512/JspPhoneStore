package pl.sda.dao;

import pl.sda.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static pl.sda.model.Brand.*;
import static pl.sda.model.OperatingSystem.ANDROID;
import static pl.sda.model.OperatingSystem.IOS;

public class ProductDaoImpl implements ProductDao {
    private static List<ProductEntity> products = loadMockData();

    @Override
    public List<ProductEntity> getProducts() {
        return products;
    }

    @Override
    public Optional<ProductEntity> getProduct(long id) {
        return products.stream().filter(p-> p.getId().equals(id)).findFirst();
    }

    private static List<ProductEntity> loadMockData() {
        Long idMock = 1L;
        ProductEntity product1 = ProductEntity.builder()
                .id(++idMock)
                .brand(SAMSUNG)
                .model("Galaxy A50 SM-A505")
                .operatingSystem(ANDROID)
                .primaryCameraMp(25)
                .secondaryCameraMp(25)
                .purchasePrice(BigDecimal.valueOf(1254.5))
                .sellingPrice(BigDecimal.valueOf(1599.90))
                .build();

        ProductEntity product2 = ProductEntity.builder()
                .id(++idMock)
                .brand(SAMSUNG)
                .model("Galaxy A40 SM-A405F")
                .operatingSystem(ANDROID)
                .primaryCameraMp(25)
                .secondaryCameraMp(16)
                .purchasePrice(BigDecimal.valueOf(885))
                .sellingPrice(BigDecimal.valueOf(1149.90))
                .build();

        ProductEntity product3 = ProductEntity.builder()
                .id(++idMock)
                .brand(SAMSUNG)
                .model("Galaxy S10 SM-G973")
                .operatingSystem(ANDROID)
                .primaryCameraMp(25)
                .secondaryCameraMp(16)
                .purchasePrice(BigDecimal.valueOf(2100))
                .sellingPrice(BigDecimal.valueOf(3949.90))
                .build();

        ProductEntity product4 = ProductEntity.builder()
                .id(++idMock)
                .brand(SAMSUNG)
                .model("Galaxy A10 SM-A105F")
                .operatingSystem(ANDROID)
                .primaryCameraMp(13)
                .secondaryCameraMp(5)
                .purchasePrice(BigDecimal.valueOf(450))
                .sellingPrice(BigDecimal.valueOf(649.90))
                .build();

        ProductEntity product5 = ProductEntity.builder()
                .id(++idMock)
                .brand(APPLE)
                .model("iPhone X 64GB")
                .operatingSystem(IOS)
                .primaryCameraMp(25)
                .secondaryCameraMp(16)
                .purchasePrice(BigDecimal.valueOf(3000))
                .sellingPrice(BigDecimal.valueOf(4049.90))
                .build();

        ProductEntity product6 = ProductEntity.builder()
                .id(++idMock)
                .brand(XIAOMI)
                .model("Redmi Note 7 4/64 GB")
                .operatingSystem(ANDROID)
                .primaryCameraMp(13)
                .secondaryCameraMp(5)
                .purchasePrice(BigDecimal.valueOf(450))
                .sellingPrice(BigDecimal.valueOf(649.90))
                .build();

        ProductEntity product7 = ProductEntity.builder()
                .id(++idMock)
                .brand(XIAOMI)
                .model("Mi 9 SE 6/128GB")
                .operatingSystem(ANDROID)
                .primaryCameraMp(13)
                .secondaryCameraMp(5)
                .purchasePrice(BigDecimal.valueOf(1100))
                .sellingPrice(BigDecimal.valueOf(1559.90))
                .build();

        return Arrays.asList(product1, product2, product3, product4, product5, product6, product7);
    }
}
