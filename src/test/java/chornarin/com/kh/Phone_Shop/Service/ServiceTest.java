package chornarin.com.kh.Phone_Shop.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import chornarin.com.kh.Phone_Shop.Impl.BrandServiceImpl;
import chornarin.com.kh.Phone_Shop.Repository.BrandRepository;
import chornarin.com.kh.Phone_Shop.models.Brand;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private BrandRepository brandRepository;

    // @Autowired
    private  BrandService brandService;

    @BeforeEach // before executing in this method it must call this fucntion first 
    public void SetUp(){
        brandService = new BrandServiceImpl(brandRepository);
    }

//     @Test
//     public void TestCreate(){
//         //  given  
//         // Brand brand = new Brand();
//         // brand.setName("TestBrand");
//         // when(brandRepository.save(any(Brand.class))).thenReturn(brand);

//         // //  when
//         // Brand savedBrand = brandService.create( new Brand());

//         // // then 
//         // assertEquals("TestBrand", savedBrand.getName());
//         // // assertEquals(1, savedBrand.getId());

//     }

    @Test
    public void FimdbyIdSuccess(){
        //given
         Brand brand = new Brand();
         brand.setName("TestBrand");
         brand.setId(1);
        //when
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
        Brand returnbyid = brandService.GetbyId(1);
        // Then
        assertEquals("TestBrand", returnbyid.getName());
        assertEquals(1, returnbyid.getId());
    }

    // @Test
    // public void GetByidthrow(){
    //     //given

    //     //when
    //     when(brandRepository.findById(2)).thenReturn(Optional.empty());
    //     assertThatThrownBy(() -> brandService.GetbyId(2))
    //     .isInstanceOf(ResourceNotFoundException.class)
    //     .hasMessage('');
    //     // Then

    // }
}
