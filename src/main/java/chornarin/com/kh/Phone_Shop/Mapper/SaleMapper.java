package chornarin.com.kh.Phone_Shop.Mapper;

import chornarin.com.kh.Phone_Shop.Dto.SaleDto;
import chornarin.com.kh.Phone_Shop.Service.SaleService;
import chornarin.com.kh.Phone_Shop.models.Sale;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring", uses = {SaleService.class})
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);


    // @Mapping()
    Sale toSale(SaleDto saleDto);

}
