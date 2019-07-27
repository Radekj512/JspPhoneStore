package pl.sda.entity;


import lombok.Builder;
import lombok.Getter;
import pl.sda.model.Brand;
import pl.sda.model.OperatingSystem;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductEntity {
    private Long id;

    private Brand brand;

    private String model;

    private BigDecimal purchasePrice;

    private BigDecimal sellingPrice;

    private OperatingSystem operatingSystem;

    private int primaryCameraMp;

    private int secondaryCameraMp;
}
