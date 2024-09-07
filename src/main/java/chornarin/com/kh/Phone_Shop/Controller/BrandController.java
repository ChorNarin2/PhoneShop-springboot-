package chornarin.com.kh.Phone_Shop.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.Branddto;
import chornarin.com.kh.Phone_Shop.Mapper.BrandMapper;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.models.Brand;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/branch")
    public ResponseEntity<?> create(@RequestBody Branddto branddto) {
        try {
            Brand brand = BrandMapper.Instance.toBrand(branddto);
            brand = brandService.create(brand);
            return ResponseEntity.ok(brand);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Getting by id
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
        Brand brand = brandService.GetbyId(brandId);
        return ResponseEntity.ok(BrandMapper.Instance.toBrandDto(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody Branddto branddto) {
        Brand brand = BrandMapper.Instance.toBrand(branddto);
        Brand updateBrand = brandService.Update(brandId, brand);
        return ResponseEntity.ok(updateBrand);
    }

    // Get all 
    @GetMapping("/all")
    public ResponseEntity<?> getsBrands() {

        List<Branddto> list = brandService.getsBrands().stream()
            .map(branch -> BrandMapper.Instance.toBrandDto(branch))
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }


    //Searching based on specification name
    @GetMapping("/name")
    public ResponseEntity<?> getsBrands(@RequestParam Map<String, String> Params) {
        Page<Brand> brand = brandService.getsBrands(Params);
        
        // List<Branddto> list = brandService.getsBrands(Params).stream()
        //     .map(branch -> BrandMapper.Instance.toBrandDto(branch))
        //     .collect(Collectors.toList());
        return ResponseEntity.ok(brand);
    }


    @GetMapping("{id}/name")
    public ResponseEntity<?> getModelbyBrand(@PathVariable("id") Integer brandId) {
        
        // List<Branddto> list = brandService.getsBrands(Params).stream()
        //     .map(branch -> BrandMapper.Instance.toBrandDto(branch))
        //     .collect(Collectors.toList());
        return ResponseEntity.ok().build();
    }


}

