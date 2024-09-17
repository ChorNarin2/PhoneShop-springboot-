package chornarin.com.kh.Phone_Shop.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import chornarin.com.kh.Phone_Shop.Dto.PriceDto;
import chornarin.com.kh.Phone_Shop.Dto.ProductImportDto;
import chornarin.com.kh.Phone_Shop.models.Product;

public interface ProductService {

    Product save(Product product);
    Product getbyid(Long id);
    // Product getByModelIdAndColorId(Long modelId, Long colorId);
    List<Product> getallproducts();
    void importproduct(ProductImportDto productImportDto);
    void SetPrice(PriceDto priceDto);
    void uploadproduct(MultipartFile file);


}
