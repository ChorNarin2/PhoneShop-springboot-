package chornarin.com.kh.Phone_Shop.Service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import chornarin.com.kh.Phone_Shop.models.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand GetbyId(Long id);
    Brand Update(Long id, Brand brand);
    List<Brand> getsBrands();
    Page<Brand> getsBrands(Map<String, String> Params);
    
    



        
} 
    


