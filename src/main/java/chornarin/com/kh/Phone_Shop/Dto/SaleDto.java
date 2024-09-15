package chornarin.com.kh.Phone_Shop.Dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleDto {

    @NotNull(message = "ProductsoldDto must be valided ")
    private List<ProductSoldDto> products;

    private LocalDateTime saledate;

    public SaleDto (){
        this.saledate = LocalDateTime.now();
    }

}
