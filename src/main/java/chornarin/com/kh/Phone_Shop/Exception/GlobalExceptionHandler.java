package chornarin.com.kh.Phone_Shop.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        ErrorResponce errorResponse = new ErrorResponce(e.getStatus(), e.getMessage());
        logger.error("Handling ApiException - Status: {}, Message: {}", e.getStatus(), e.getMessage());
        return ResponseEntity
            .status(e.getStatus())
            .body(errorResponse);
    }
}
