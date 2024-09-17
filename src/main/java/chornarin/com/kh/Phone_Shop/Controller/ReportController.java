package chornarin.com.kh.Phone_Shop.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.ProductReportDto;
import chornarin.com.kh.Phone_Shop.Service.ReportService;
import chornarin.com.kh.Phone_Shop.Service.SaleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final SaleService saleService;
    private final ReportService reportService;

    @GetMapping("/{startdate}/{enddate}")
    public ResponseEntity<?> productsold(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate startdate ,@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate enddate){
        List<ProductReportDto> productReports = reportService.getProductReport(startdate, enddate);
        return ResponseEntity.ok(productReports);
    }



}
