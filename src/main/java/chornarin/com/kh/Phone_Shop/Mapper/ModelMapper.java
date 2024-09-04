package chornarin.com.kh.Phone_Shop.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import chornarin.com.kh.Phone_Shop.Dto.ModelDto;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.models.PhoneModel;

@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
    ModelMapper Instance = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand", source = "brandId")
    PhoneModel toModel(ModelDto modelDto);

   


}
