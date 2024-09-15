package chornarin.com.kh.Phone_Shop.Impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import chornarin.com.kh.Phone_Shop.Dto.ProductSoldDto;
import chornarin.com.kh.Phone_Shop.Dto.SaleDto;
import chornarin.com.kh.Phone_Shop.Exception.ApiException;
import chornarin.com.kh.Phone_Shop.Repository.ProductRepository;
import chornarin.com.kh.Phone_Shop.Repository.SaleDatailRepository;
import chornarin.com.kh.Phone_Shop.Repository.SaleRepository;
import chornarin.com.kh.Phone_Shop.Service.ProductService;
import chornarin.com.kh.Phone_Shop.Service.SaleService;
import chornarin.com.kh.Phone_Shop.models.Product;
import chornarin.com.kh.Phone_Shop.models.Sale;
import chornarin.com.kh.Phone_Shop.models.SaleDetail;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final SaleDatailRepository saleDetailRepository;  // Inject SaleDetailRepository

    @Override
    public void processSale(SaleDto saleDto) {
        validateSale(saleDto);
    }

    private void validateSale(SaleDto saleDto) {
        List<Long> products = saleDto.getProducts().stream()
            .map(ProductSoldDto::getProductId)
            .toList();

        products.forEach(productId -> productService.getbyid(productId));

        List<Product> productList = productRepository.findAllById(products);
        Map<Long, Product> productMap = productList.stream()
            .collect(Collectors.toMap(Product::getId, Function.identity()));

        saleDto.getProducts().forEach(ps -> {
            Product product = productMap.get(ps.getProductId());
            if (product.getAvailableUint() < ps.getNumberofunits()) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "Product is out of stock");
            }
            
        });
        
        // Save sale
        Sale sale = new Sale();
        sale.setSolddate(saleDto.getSaledate());
        saleRepository.save(sale);

        //save detail
        saleDto.getProducts().forEach(ps -> {
            Product product = productMap.get(ps.getProductId());
            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setAmount(product.getSalePrice());
            saleDetail.setProductid(productMap.get(ps.getProductId()));
            saleDetail.setSale(sale);
            saleDetail.setUnit(ps.getNumberofunits());
            saleDetailRepository.save(saleDetail);  
        });


        // Cut stock
        saleDto.getProducts().forEach(ps -> {
            Product product = productMap.get(ps.getProductId());
            Integer avialableunit = product.getAvailableUint() - ps.getNumberofunits();
            product.setAvailableUint(avialableunit);
            productRepository.save(product);
            
        });



         //     //cut stock
        //     Integer availableunit = productss.getAvailableUint() - ps.getNumberofunits();
        //     productss.setAvailableUint(availableunit);
        //     productRepository.save(productss);

        // });

    }
}

         //method 1
        // private void validate(SaleDto saleDto) {

        //     saleDto.getProducts().forEach(
        //         ps -> {
        //             Product product = productService.getbyid(ps.getProductId());
        //             if(product.getAvailableUint() < ps.getNumberofunits()){
        //                 throw new ApiException(HttpStatus.BAD_REQUEST, "The product is out of stock");
        //             }

        //         }
        //     );

        // }


       

       
