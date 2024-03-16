import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;
import org.nextples.model.Print;

public class PrintTest {
    @Test
    public void printIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        NonParameterCommand command = new Print();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
