package chornarin.com.kh.Phone_Shop.Exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponce {
    private HttpStatus status;
    private String message;

}
