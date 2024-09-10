package chornarin.com.kh.Phone_Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chornarin.com.kh.Phone_Shop.Dto.ModelDto;
import chornarin.com.kh.Phone_Shop.Mapper.ModelMapper;
import chornarin.com.kh.Phone_Shop.Service.ModelService;
import chornarin.com.kh.Phone_Shop.models.PhoneModel; // Ensure this import is correct



@RestController
@RequestMapping("/model")
// @RequiredArgsConstructor
public class ModelController {

    @Autowired
    private  ModelService modelService; // Constructor-based dependency injection using 

    @Autowired
    private  ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDto modelDto) {
        PhoneModel model = modelMapper.toPhoneModel(modelDto);
        return ResponseEntity.ok(modelService.save(model));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<PhoneModel> list = modelService.getModels();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> GetbybrandId(@PathVariable("id") Long brandId) {
        PhoneModel list  = modelService.getbybrandId(brandId);
        ModelDto modelDto = modelMapper.toModelDto(list);
        return ResponseEntity.ok(modelDto);
    }
    
}
