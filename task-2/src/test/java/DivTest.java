import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.Div;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;

public class DivTest {
    @Test
    public void divTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        context.getStack().push(5.0);

        NonParameterCommand command = new Div();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(1.0, context.getStack().peek());
    }

    @Test
    public void divArithmeticExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        context.getStack().push(0.0);
        NonParameterCommand command = new Div();
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            command.execute(context);
        });
    }

    @Test
    public void divIllegalAccessExceptionTest2() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(5.0);
        NonParameterCommand command = new Div();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
