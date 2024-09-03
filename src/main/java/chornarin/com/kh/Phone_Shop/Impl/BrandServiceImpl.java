package chornarin.com.kh.Phone_Shop.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Repository.BrandRepository;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.Util.PageUtil;
import chornarin.com.kh.Phone_Shop.models.Brand;
import chornarin.com.kh.Phone_Shop.spec.BrandFilter;
import chornarin.com.kh.Phone_Shop.spec.BrandSpec;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
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

    @Override
    public List<Brand> getsBrands() {
        return brandRepository.findAll();
    }


    @Override
    public Page<Brand> getsBrands(Map<String, String> Params) {
        BrandFilter brandFilter = new BrandFilter();


        if(Params.containsKey("name")){
            brandFilter.setName(Params.get("name"));
        }
        if(Params.containsKey("id")){
            String id = Params.get("id");
            brandFilter.setId(Integer.parseInt(id));
        }

        int pageLimit  = 1;
        if(Params.containsKey(PageUtil.PAG_LIMIT)){
            String limit = Params.get(PageUtil.PAG_LIMIT);
            // Pageable pagelimit = PageRequest.of(pageLimit, Integer.parseInt(limit));
            pageLimit = Integer.parseInt(limit);
            
        }
        int pageNumber  = 1;
        if(Params.containsKey(PageUtil.PAG_NUMBER)){
            String Number = Params.get(PageUtil.PAG_NUMBER);
            // Pageable pagenumber = PageRequest.of(pageNumber, Integer.parseInt(Number));
            pageNumber = Integer.parseInt(Number);
            
        }

        BrandSpec brandSpec = new BrandSpec(brandFilter);
        Pageable pageable = PageUtil.Getpageable(pageLimit, pageNumber);
        Page<Brand> page =  brandRepository.findAll(brandSpec, pageable);

        return page;
    }

}
