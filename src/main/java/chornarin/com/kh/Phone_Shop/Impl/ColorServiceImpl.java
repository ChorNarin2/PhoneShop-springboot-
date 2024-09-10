package chornarin.com.kh.Phone_Shop.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chornarin.com.kh.Phone_Shop.Exception.ResourceNotFoundException;
import chornarin.com.kh.Phone_Shop.Repository.ColorRepository;
import chornarin.com.kh.Phone_Shop.Service.ColorService;
import chornarin.com.kh.Phone_Shop.models.Color;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color create(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color GetById(Long id) {
        return colorRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("colors_id", id));
    }

}
