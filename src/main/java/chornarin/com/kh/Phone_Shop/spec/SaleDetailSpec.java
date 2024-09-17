package chornarin.com.kh.Phone_Shop.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Predicates;
import org.springframework.lang.Nullable;

import chornarin.com.kh.Phone_Shop.models.SaleDetail;
import chornarin.com.kh.Phone_Shop.models.Sale;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Join;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class SaleDetailSpec implements Specification <SaleDetail> {

    private SaleDatailFilter SaleDatailFilter;

    

    @Override
    public Predicate toPredicate(Root<SaleDetail> saleDatail, @Nullable CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                Join<SaleDetail, Sale> sale =  saleDatail.join("sale");
                if(Objects.nonNull(SaleDatailFilter.getStarDate())){
                    // saleDatail.get("solddate");
                    criteriaBuilder.greaterThanOrEqualTo(sale.get("solddate"), SaleDatailFilter.getStarDate());
                }
                if(Objects.nonNull(SaleDatailFilter.getEndDate())){
                    // saleDatail.get("solddate");
                    criteriaBuilder.lessThanOrEqualTo(sale.get("solddate"), SaleDatailFilter.getEndDate());
                }

                Predicate predicate = criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            return predicate;

    }

}
