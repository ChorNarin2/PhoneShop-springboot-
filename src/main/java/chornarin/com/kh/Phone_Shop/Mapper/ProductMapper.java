package chornarin.com.kh.Phone_Shop.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import chornarin.com.kh.Phone_Shop.Dto.ProductDto;
import chornarin.com.kh.Phone_Shop.Service.ColorService;
import chornarin.com.kh.Phone_Shop.Service.ModelService;
import chornarin.com.kh.Phone_Shop.models.Product;

@Mapper(componentModel = "spring", uses = {ModelService.class, ColorService.class})
public interface ProductMapper {
    
    ProductMapper Instance = Mappers.getMapper(ProductMapper.class);


    @Mapping(target = "phoneModel", source = "phonemodel_id")
    @Mapping(target = "color", source = "color_id")
    Product toproduct(ProductDto productDto);

    // @Mapping(target = "color_id", source  = "id")
    // ProductDto toProductDto(Product product);

}
