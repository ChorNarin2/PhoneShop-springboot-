package chornarin.com.kh.Phone_Shop.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductReportDto {

    // productId, productName, unit, totalAmount
    private Long productId;
    private String productName;
    private Integer unit;
    private BigDecimal totalAmount;

}
