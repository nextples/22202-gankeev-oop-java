import org.example.AnswerProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerProcessorTest {

    @Test
    void positionsTest() {
        AnswerProcessor answerProcessor = new AnswerProcessor();

        answerProcessor.check("1234", "1234");
        Assertions.assertEquals(4, answerProcessor.getMatchingPos());
        Assertions.assertEquals(0, answerProcessor.getMisMatchingPos());

        answerProcessor.check("1233", "1234");
        Assertions.assertEquals(3, answerProcessor.getMatchingPos());
        Assertions.assertEquals(1, answerProcessor.getMisMatchingPos());

        answerProcessor.check("1111", "1234");
        Assertions.assertEquals(1, answerProcessor.getMatchingPos());
        Assertions.assertEquals(3, answerProcessor.getMisMatchingPos());

        answerProcessor.check("5678", "1234");
        Assertions.assertEquals(0, answerProcessor.getMatchingPos());
        Assertions.assertEquals(0, answerProcessor.getMisMatchingPos());

        answerProcessor.check("4567", "1234");
        Assertions.assertEquals(0, answerProcessor.getMatchingPos());
        Assertions.assertEquals(1, answerProcessor.getMisMatchingPos());

        answerProcessor.check("1243", "1234");
        Assertions.assertEquals(2, answerProcessor.getMatchingPos());
        Assertions.assertEquals(2, answerProcessor.getMisMatchingPos());
    }
}
