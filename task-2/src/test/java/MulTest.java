import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.Mul;
import org.nextples.model.NonParameterCommand;

public class MulTest {
    @Test
    public void mulTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        context.getStack().push(5.0);

        NonParameterCommand command = new Mul();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(25.0, context.getStack().peek());
    }

    @Test
    public void mulIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        NonParameterCommand command = new Mul();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
