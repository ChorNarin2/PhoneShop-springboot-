package chornarin.com.kh.Phone_Shop.Projection;

import java.math.BigDecimal;

public interface ProductSold {
    // productId, productName, unit, totalAmount

    Long getProductId();
    String getProductName();
    Integer getUnit();
    BigDecimal getTotalAmount();

}
