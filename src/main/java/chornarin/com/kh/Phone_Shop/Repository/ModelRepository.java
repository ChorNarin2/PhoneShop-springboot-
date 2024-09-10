package chornarin.com.kh.Phone_Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.models.PhoneModel;

@Repository
public interface ModelRepository extends JpaRepository<PhoneModel, Long > {

    PhoneModel findByBrandId(Integer brandId);
    

}
