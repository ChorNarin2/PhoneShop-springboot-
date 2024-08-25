package chornarin.com.kh.Phone_Shop.Util;

import chornarin.com.kh.Phone_Shop.Dto.Branddto;
import chornarin.com.kh.Phone_Shop.models.Brand;

// clease is used to transform table's model to dro and reversing 
public class Mapper {

    public static Brand toBrand(Branddto dto){
        Brand brand = new Brand();
        brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }

}
