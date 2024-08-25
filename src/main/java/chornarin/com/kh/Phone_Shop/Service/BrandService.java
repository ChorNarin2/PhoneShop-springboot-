package chornarin.com.kh.Phone_Shop.Service;

import chornarin.com.kh.Phone_Shop.models.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand GetbyId(Integer id);
    Brand Update(Integer id, Brand brand);

    
} 
    


