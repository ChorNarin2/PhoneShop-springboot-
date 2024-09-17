package chornarin.com.kh.Phone_Shop.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.Projection.ProductSold;
import chornarin.com.kh.Phone_Shop.models.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // List<ProductSold> findProductSold(LocalDate startDate, LocalDate endDate);


}
