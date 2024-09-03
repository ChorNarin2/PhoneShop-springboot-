package chornarin.com.kh.Phone_Shop.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import chornarin.com.kh.Phone_Shop.models.Brand;

@DataJpaTest
public class BrandRepositoryTest {
    @Autowired
    private BrandRepository brandRepository;


    @Test
    public void TestfindByNameLike(){
        Brand brand = new Brand();
        brand.setName("chor");
        brandRepository.save(brand);
        // when

        List<Brand> brandFilter = brandRepository.findByNameLike("%c%");


        // then

        assertEquals(1,brandFilter.size());
        assertEquals("chor", brandFilter.get(0).getName());
        
    }

}
