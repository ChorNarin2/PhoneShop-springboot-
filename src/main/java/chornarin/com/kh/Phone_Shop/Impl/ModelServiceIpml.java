package chornarin.com.kh.Phone_Shop.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Repository.ModelRepository;
import chornarin.com.kh.Phone_Shop.Service.ModelService;
import chornarin.com.kh.Phone_Shop.models.PhoneModel;

@Service
public class ModelServiceIpml implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public PhoneModel save(PhoneModel model) {
        return modelRepository.save(model);
    }

    @Override
    public List<PhoneModel> getModels() {
        return modelRepository.findAll();
    }

    @Override
    public PhoneModel getbybrandId(Long phonemodelId) {
        return modelRepository.findById(phonemodelId)
        .orElseThrow(() -> new ResourceNotFoundException("id", phonemodelId));
    }


}
