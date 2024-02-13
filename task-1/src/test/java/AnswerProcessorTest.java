import org.example.AnswerProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerProcessorTest {

    @Test
    void isGuessValidTest() {
        Assertions.assertTrue(AnswerProcessor.isGuessValid("3215"));
        Assertions.assertTrue(AnswerProcessor.isGuessValid("9712"));
        Assertions.assertFalse(AnswerProcessor.isGuessValid("32150"));
        Assertions.assertFalse(AnswerProcessor.isGuessValid("32 15"));
        Assertions.assertTrue(AnswerProcessor.isGuessValid("3255"));
        Assertions.assertTrue(AnswerProcessor.isGuessValid("3333"));
        Assertions.assertFalse(AnswerProcessor.isGuessValid("32a15"));
        Assertions.assertFalse(AnswerProcessor.isGuessValid("abcd"));
        Assertions.assertFalse(AnswerProcessor.isGuessValid(""));
        Assertions.assertFalse(AnswerProcessor.isGuessValid(" "));
        Assertions.assertFalse(AnswerProcessor.isGuessValid("\n"));
    }
}
