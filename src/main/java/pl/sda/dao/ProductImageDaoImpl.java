package pl.sda.dao;

public class ProductImageDaoImpl implements ProductImageDao {
    @Override
    public String getImagePathForProduct(Long id) {
        return "/image/iphone.png";
    }
}
