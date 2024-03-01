import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;
import org.nextples.model.Pop;

public class PopTest {
    @Test
    public void popTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        NonParameterCommand command = new Pop();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
        Assertions.assertTrue(context.getStack().empty());
    }

    @Test
    public void popIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        NonParameterCommand command = new Pop();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
