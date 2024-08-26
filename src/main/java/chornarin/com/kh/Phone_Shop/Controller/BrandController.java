package chornarin.com.kh.Phone_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.Branddto;
import chornarin.com.kh.Phone_Shop.Mapper.BrandMapper;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.models.Brand;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandService BrandService;

    @RequestMapping("/branch")
    public  ResponseEntity<?> create(@RequestBody Branddto  branddto) {

        try{
            Brand brand = BrandMapper.Instance.toBrand(branddto);
            brand = BrandService.create(brand);
            return ResponseEntity.ok(brand);

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
        Brand brand = BrandService.GetbyId(brandId);
        return ResponseEntity.ok(BrandMapper.Instance.toBrandDto(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody Branddto branddto){
        Brand brand = BrandMapper.Instance.toBrand(branddto);
        Brand updateBrand = BrandService.Update(brandId, brand);
        return ResponseEntity.ok(updateBrand);
    }

}
