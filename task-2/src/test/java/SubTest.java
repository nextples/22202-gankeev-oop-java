import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;
import org.nextples.model.Sub;

public class SubTest {
    @Test
    public void subTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        context.getStack().push(5.0);

        NonParameterCommand command = new Sub();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(0.0, context.getStack().peek());
    }

    @Test
    public void subIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        NonParameterCommand command = new Sub();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
