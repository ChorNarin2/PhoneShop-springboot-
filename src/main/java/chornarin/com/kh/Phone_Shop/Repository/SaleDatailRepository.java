package chornarin.com.kh.Phone_Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.models.SaleDetail;

@Repository
public interface SaleDatailRepository extends JpaRepository<SaleDetail, Long>, JpaSpecificationExecutor<SaleDetail> {

    List<SaleDetail> findBySaleId(Long saleId);

}
