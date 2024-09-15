package chornarin.com.kh.Phone_Shop.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.SaleDto;
import chornarin.com.kh.Phone_Shop.Service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    // Insert data into sales table
    @PostMapping("/save")
    public ResponseEntity<?> processSale( @Valid @RequestBody SaleDto saleDto, BindingResult BindingResult) {  
        if(BindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(BindingResult.getFieldError().getDefaultMessage());
        }
        saleService.processSale(saleDto);
        return ResponseEntity.ok().build();
    }
}
