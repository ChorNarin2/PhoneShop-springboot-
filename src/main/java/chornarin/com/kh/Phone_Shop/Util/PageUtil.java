package chornarin.com.kh.Phone_Shop.Util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

public interface PageUtil {
    int DEFUALT_PAGE_LIMIT = 6;
    int DEFUALT_PAG_NUMBER = 1;
    String PAG_LIMIT = "_limit";
    String PAG_NUMBER = "_page";

    static Pageable Getpageable(int pageNumber, int pageSize){

        if(pageNumber < DEFUALT_PAG_NUMBER){
            pageNumber = DEFUALT_PAG_NUMBER;
        }
        if(pageSize < 1){
            pageSize = DEFUALT_PAGE_LIMIT;
        }
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);

        return pageable;

    }
}
