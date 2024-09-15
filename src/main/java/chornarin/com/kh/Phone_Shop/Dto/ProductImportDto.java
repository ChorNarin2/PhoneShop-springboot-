package chornarin.com.kh.Phone_Shop.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductImportDto {

    @NotNull(message = "productId can not be null")
    private Long productId;

    @Min(value=1, message = "the importUnit must be at least 1")
    private Integer importUnit;

    @DecimalMin(value = "0.0000001" , message = "importprice must be greater than 0")
    private BigDecimal importPrice;


    private LocalDateTime importDate;

    public ProductImportDto(){
        this.importDate = LocalDateTime.now();
    }

}
