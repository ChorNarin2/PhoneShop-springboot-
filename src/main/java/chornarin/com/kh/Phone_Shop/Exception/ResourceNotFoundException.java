package chornarin.com.kh.Phone_Shop.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {



    public ResourceNotFoundException(String Resourcename, Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s with id =  %d not found", Resourcename, id));
    }

}
