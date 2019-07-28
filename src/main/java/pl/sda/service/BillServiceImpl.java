package pl.sda.service;

import pl.sda.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public BigDecimal getFinalBill(List<Product> products) {
        final BigDecimal[] finalBill = {BigDecimal.ZERO};
        products.forEach(p-> finalBill[0] = finalBill[0].add(p.getPrice()));
        return finalBill[0];
    }
}
