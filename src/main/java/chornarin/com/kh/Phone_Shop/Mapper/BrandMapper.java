package chornarin.com.kh.Phone_Shop.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// import org.mapstruct.factory.Mappers;

import chornarin.com.kh.Phone_Shop.Dto.Branddto;
import chornarin.com.kh.Phone_Shop.models.Brand;

@Mapper
public interface BrandMapper   {
    BrandMapper Instance = Mappers.getMapper(BrandMapper.class);
    // Transforming Brand entity to BrandDto entity
    Brand toBrand(Branddto dto);
    // Transforming BrandDto entity to Brand entity
    Branddto toBrandDto(Brand entity);

}
