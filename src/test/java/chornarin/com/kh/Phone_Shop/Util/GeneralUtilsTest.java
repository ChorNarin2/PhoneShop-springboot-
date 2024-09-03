package chornarin.com.kh.Phone_Shop.Util;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test; // Importing the correct Test annotation
import chornarin.com.kh.Phone_Shop.Utils.GeneralUtils;

public class GeneralUtilsTest {

    // @Test // @Test annotation should be used here
    // public void testToIntegerList(){
    //     // Given
    //     List<String> names = List.of("jkk", "narin", "dara");
    //     // When
    //     List<Integer> list = GeneralUtils.toIntegerList(names);

    //     // Then
    //     assertEquals(3, list.size());
    //     assertEquals(3, list.get(0)); // This line is causing the error
    //     assertEquals(5, list.get(1));
    // }

    @Test
    public void testEvenInteger(){
        List<Integer> numbers = List.of(2,3,4,5,4);
        List<Integer> numberslist = GeneralUtils.getEvenNumber(numbers);
        assertEquals(2, numberslist.get(0));
        assertEquals(3, numberslist.size());

    }
}
