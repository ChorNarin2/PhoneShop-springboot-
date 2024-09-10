package chornarin.com.kh.Phone_Shop.Service;

import chornarin.com.kh.Phone_Shop.models.Color;

public interface ColorService {

    Color create(Color color);
    Color GetById(Long id);

}
