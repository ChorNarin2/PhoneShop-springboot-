package chornarin.com.kh.Phone_Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.models.PhoneModel;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<PhoneModel, Integer > {

    PhoneModel findByBrandId(Integer brandId);
    

}
