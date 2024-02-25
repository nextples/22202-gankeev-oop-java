import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.stackcalculator.*;

public class DefineTest {
    @Test
    public void defineTest1() throws InvalidArgumentException, InvalidParameterNameException {
        ExecutionContext context = ExecutionContext.init();
        Define define = new Define();
        String arg = "a 25";
        StackCalculator.executeCommand(define, arg, context);
        Assertions.assertEquals(25, context.mapGet("a"));
    }

    @Test
    public void defineTest2() throws InvalidArgumentException, InvalidParameterNameException {
        ExecutionContext context = ExecutionContext.init();
        Define define = new Define();
        String arg = "abc -25";
        StackCalculator.executeCommand(define, arg, context);
        Assertions.assertEquals(-25, context.mapGet("abc"));
    }

    @Test
    public void defineTest3() throws InvalidArgumentException, InvalidParameterNameException {
        ExecutionContext context = ExecutionContext.init();
        Define define = new Define();
        String arg = "a";
        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
            StackCalculator.executeCommand(define, arg, context);
        });
    }

    @Test
    public void defineTest4() throws InvalidArgumentException, InvalidParameterNameException {
        ExecutionContext context = ExecutionContext.init();
        Define define = new Define();
        String arg = "25 25";
        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
            StackCalculator.executeCommand(define, arg, context);
        });
    }

    @Test
    public void defineTest5() throws InvalidArgumentException, InvalidParameterNameException {
        ExecutionContext context = ExecutionContext.init();
        Define define = new Define();
        String arg = "";
        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
            StackCalculator.executeCommand(define, arg, context);
        });
    }
}
