package chornarin.com.kh.Phone_Shop.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Brand read(Brand brand) {
        Brand Brand = new Brand();
        Brand.setId(brand.getId());
        return brandRepository.findById(brand.getId()).orElse(null);


    }
};
