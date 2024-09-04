package chornarin.com.kh.Phone_Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chornarin.com.kh.Phone_Shop.models.PhoneModel;

public interface ModelRepository extends JpaRepository<PhoneModel, Integer > {
    

}
