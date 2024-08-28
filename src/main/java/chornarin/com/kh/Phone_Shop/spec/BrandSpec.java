package chornarin.com.kh.Phone_Shop.spec;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import chornarin.com.kh.Phone_Shop.models.Brand;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class BrandSpec implements Specification<Brand> {

    private final BrandFilter brandFilter;



    List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder bc) {
        if(brandFilter.getName() != null){
        //    Predicate name =  brand.get("name").in(brandFilter.getName());
        //    predicates.add(name);
        Predicate name = 
           bc.like(brand.get("name"),"%"+brandFilter.getName()+"%");
            predicates.add(name);
        }
        if(brandFilter.getId() != null){
            Predicate brandId =  brand.get("id").in(brandFilter.getId());
            predicates.add (brandId);
        }

        Predicate[] get = predicates.toArray(Predicate[]::new);
        return bc.and(get);
    }

}
