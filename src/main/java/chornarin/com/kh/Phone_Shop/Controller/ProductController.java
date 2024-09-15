package chornarin.com.kh.Phone_Shop.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chornarin.com.kh.Phone_Shop.Dto.PriceDto;
import chornarin.com.kh.Phone_Shop.Dto.ProductDto;
import chornarin.com.kh.Phone_Shop.Dto.ProductImportDto;
import chornarin.com.kh.Phone_Shop.Mapper.ProductMapper;
import chornarin.com.kh.Phone_Shop.Service.ProductService;
import chornarin.com.kh.Phone_Shop.models.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    // insert data into products table
    @PostMapping("/save")
    public ResponseEntity<?> createproduct(@RequestBody ProductDto productdDto){
        Product product2 = productMapper.toproduct(productdDto);
        Product product3 = productService.save(product2);
        return ResponseEntity.ok(product3.getName());
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getproducts(){
        List<Product>  list = productService.getallproducts();
        return ResponseEntity.ok(list);
    }


    @PostMapping("/importproduct")
    public ResponseEntity<?> importproduct(@Valid @RequestBody ProductImportDto productImportDto
    , BindingResult BindingResult){
        if(BindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(BindingResult.getFieldError().getDefaultMessage());
        }
        productService.importproduct(productImportDto);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/setprice")
    public ResponseEntity<?> updatePrice(@RequestBody PriceDto Price){
        if(Price.getId() == null){
            throw new IllegalArgumentException("id is required");
        }
        productService.SetPrice(Price);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/uploadproduct")
    public ResponseEntity<?> uploadproduct(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("file is missing");
        }
        productService.uploadproduct(file);
        return ResponseEntity.ok().build();
    }
}   
