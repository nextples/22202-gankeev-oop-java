import org.example.DigitValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitValidatorTest {
    @Test
    void validatorTest() {
        boolean test = DigitValidator.isNumberValid("1234", 4);
        Assertions.assertTrue(test);

        test = DigitValidator.isNumberValid("1111", 4);
        Assertions.assertTrue(test);

        test = DigitValidator.isNumberValid("12345", 4);
        Assertions.assertFalse(test);

        test = DigitValidator.isNumberValid("abcd", 4);
        Assertions.assertFalse(test);

        test = DigitValidator.isNumberValid("ab34", 4);
        Assertions.assertFalse(test);

        test = DigitValidator.isNumberValid("", 4);
        Assertions.assertFalse(test);
    }
}
