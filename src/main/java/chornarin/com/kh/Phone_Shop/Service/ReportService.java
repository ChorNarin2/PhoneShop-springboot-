package chornarin.com.kh.Phone_Shop.Service;

import java.time.LocalDate;
import java.util.List;


import chornarin.com.kh.Phone_Shop.Dto.ProductReportDto;

public interface ReportService {

    List<ProductReportDto> getProductReport(LocalDate starDate, LocalDate endDate);


}
