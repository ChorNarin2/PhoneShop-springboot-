package chornarin.com.kh.Phone_Shop.Impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import chornarin.com.kh.Phone_Shop.models.Product;
import chornarin.com.kh.Phone_Shop.Dto.ProductReportDto;
import chornarin.com.kh.Phone_Shop.Repository.ProductRepository;
import chornarin.com.kh.Phone_Shop.Repository.SaleDatailRepository;
import chornarin.com.kh.Phone_Shop.Repository.SaleRepository;
import chornarin.com.kh.Phone_Shop.Service.ReportService;
import chornarin.com.kh.Phone_Shop.models.SaleDetail;
import chornarin.com.kh.Phone_Shop.spec.SaleDatailFilter;
import chornarin.com.kh.Phone_Shop.spec.SaleDetailSpec;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
    private final SaleDatailRepository saleDatailRepository;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductReportDto> getProductReport(LocalDate starDate, LocalDate endDate) {
        List<ProductReportDto> productReportDtoList = new ArrayList<>();
        SaleDatailFilter saleDatailFilter = new SaleDatailFilter();
        saleDatailFilter.setEndDate(starDate);
        saleDatailFilter.setEndDate(endDate);
        Specification<SaleDetail> spec = new SaleDetailSpec(saleDatailFilter);
        List<SaleDetail> saleDetails =  saleDatailRepository.findAll(spec);

        List<Long> productIds = saleDetails.stream()
        .map(sd -> sd.getProductid().getId())
        .toList();

        Map<Long, Product> productMap = productRepository.findAllById(productIds)
        .stream()
        .collect(Collectors.toMap(Product::getId, Function.identity()));

        Map<Product, List<SaleDetail>> saleDetainMap = saleDetails.stream()
        .collect(Collectors.groupingBy(SaleDetail::getProductid));

        for(Map.Entry<Product, List<SaleDetail>> entry : saleDetainMap.entrySet()){
            Product product = productMap.get(entry.getKey().getId());
            ProductReportDto productReportDto = new ProductReportDto();

            List<SaleDetail> sdlList = entry.getValue();

            //total unit
            Integer totalAmount = sdlList.stream().map(SaleDetail::getUnit)
            .reduce(0, (a,b) -> a + b);
            //total amount
            Double totalAmountBD = sdlList.stream()
            .map(sd -> sd.getUnit() * sd.getAmount().doubleValue())
            .reduce(0.0, (a,b) -> a + b);
            


            productReportDto.setProductId(product.getId());
            productReportDto.setProductName(product.getName());
            productReportDto.setUnit(totalAmount);
            productReportDto.setTotalAmount(BigDecimal.valueOf(totalAmountBD));;
            productReportDtoList.add(productReportDto);
        }
        return productReportDtoList;

    
    }

}
