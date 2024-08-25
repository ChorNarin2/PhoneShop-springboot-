package chornarin.com.kh.Phone_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.Branddto;
import chornarin.com.kh.Phone_Shop.Service.BrandService;
import chornarin.com.kh.Phone_Shop.Util.Mapper;
import chornarin.com.kh.Phone_Shop.models.Brand;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandService BrandService;

    @RequestMapping("/branch")
    public  ResponseEntity<?> create(@RequestBody Branddto  branddto) {

        try{
            Brand brand = Mapper.toBrand(branddto);
            brand = BrandService.create(brand);
            return ResponseEntity.ok(brand);

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // get brandne
    @GetMapping("/branch")
    public ResponseEntity<?> getBrandById(@RequestBody Branddto  branddto) {
        try {
            Brand brand = Mapper.toBrand(branddto);
            brand = BrandService.read(brand);
            return ResponseEntity.ok(brand);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
