package chornarin.com.kh.Phone_Shop.Service;

import chornarin.com.kh.Phone_Shop.Dto.SaleDto;
import chornarin.com.kh.Phone_Shop.models.Sale;

public interface SaleService {

    void processSale(SaleDto saleDto);
    Sale getbyId(Long saleId);
    void saleSale(Long saleId);



}
