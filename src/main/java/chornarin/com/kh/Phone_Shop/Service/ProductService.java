package chornarin.com.kh.Phone_Shop.Service;

import java.util.List;
import chornarin.com.kh.Phone_Shop.models.Product;

public interface ProductService {

    Product save(Product product);
    Product getbyid(Long id);
    List<Product> getproduct();

}
