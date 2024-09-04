package chornarin.com.kh.Phone_Shop.Service;

import java.util.List;

import chornarin.com.kh.Phone_Shop.models.PhoneModel;

public interface ModelService {

    PhoneModel save(PhoneModel model);
    List<PhoneModel> getModels();

}
