import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.ExecutionContext;
import org.nextples.model.NonParameterCommand;
import org.nextples.model.Sqrt;

public class SqrtTest {
    @Test
    public void sqrtTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(25.0);
        NonParameterCommand command = new Sqrt();
        try {
            command.execute(context);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(5.0, context.getStack().peek());
    }

    @Test
    public void sqrtArithmeticExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(-5.0);
        NonParameterCommand command = new Sqrt();
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            command.execute(context);
        });
    }

    @Test
    public void sqrtIllegalAccessExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        NonParameterCommand command = new Sqrt();
        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
            command.execute(context);
        });
    }
}
