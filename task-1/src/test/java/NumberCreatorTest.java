import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberCreatorTest {

    @Test
    void createTest() {
        String number = NumberCreator.create();
        Assertions.assertEquals(4, number.length());
        boolean isAllDifferent = (number.charAt(0) != number.charAt(1)) && (number.charAt(0) != number.charAt(2)) &&
                (number.charAt(0) != number.charAt(3)) && (number.charAt(1) != number.charAt(2)) &&
                (number.charAt(1) != number.charAt(3)) && (number.charAt(2) != number.charAt(3));
        Assertions.assertTrue(isAllDifferent);
    }
}
