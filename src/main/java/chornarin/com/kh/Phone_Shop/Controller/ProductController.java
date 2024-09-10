package chornarin.com.kh.Phone_Shop.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.ProductDto;
import chornarin.com.kh.Phone_Shop.Mapper.ProductMapper;
import chornarin.com.kh.Phone_Shop.Service.ProductService;
import chornarin.com.kh.Phone_Shop.models.Product;
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
        List<Product>  list = productService.getproduct();
        // .map(pruduct -> List<pruduct>)
        // .toList(Collectors.)

        return ResponseEntity.ok(list);
    }
}
