package chornarin.com.kh.Phone_Shop.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Repository.ProductRepository;
import chornarin.com.kh.Phone_Shop.Service.ProductService;
import chornarin.com.kh.Phone_Shop.models.Product;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // save to database
    @Override
    public Product save(Product product) {
        String name = "%s %s".formatted(product.getPhoneModel().getName(), product.getColor().getColor_name());
        product.setName(name); 
        return productRepository.save(product);
    }

    //retreive by id
    @Override
    public Product getbyid(Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    // retrieve all data from the table products
    @Override
    public List<Product> getproduct() {
        return productRepository.findAll();
    }

}
