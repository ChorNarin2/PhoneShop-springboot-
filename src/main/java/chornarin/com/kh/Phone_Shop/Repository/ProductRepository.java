package chornarin.com.kh.Phone_Shop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import chornarin.com.kh.Phone_Shop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, 
JpaSpecificationExecutor<Product> {

    Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);

}
