import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;
import org.nextples.model.Plus;

public class PlusTest {
    @Test
    public void plusTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        context.getStack().push(5.0);

        NonParameterCommand command = new Plus();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(10.0, context.getStack().peek());
    }

    @Test
    public void plusIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        NonParameterCommand command = new Plus();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
