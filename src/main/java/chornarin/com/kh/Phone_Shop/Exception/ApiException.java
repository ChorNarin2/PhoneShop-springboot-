package chornarin.com.kh.Phone_Shop.Exception;

import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
