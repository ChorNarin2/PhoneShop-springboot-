package chornarin.com.kh.Phone_Shop.Utils;

import java.util.List;

public class GeneralUtils {

    //  Convert list of String to List of Integer
    //EX: ["CHOR", "NARIN", "DATAT"] -> [4,5,5]

    public static List<Integer> toIntegerList(List<String> list){
        
        return 
        list.stream()
        .map(n -> n.length())
        .toList();
        
    }

    public static List<Integer> getEvenNumber (List<Integer> list){
        return 
        list.stream()
        .filter(n -> n % 2 == 0)
        .toList();
    }

}
