package chornarin.com.kh.Phone_Shop.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Repository.BrandRepository;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.models.Brand;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand GetbyId(Integer id) {
        return brandRepository.findById(id)
            // .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand not found for ID: %d", id)));
            .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand Update(Integer id, Brand brand){
        Brand brand2 = GetbyId(id);
        brand2.setName(brand.getName()); 
        return brandRepository.save(brand2);
    }
}
