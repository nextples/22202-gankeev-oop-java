import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.Define;
import org.nextples.model.ExecutionContext;
import org.nextples.model.ParameterCommand;

import java.util.ArrayList;
import java.util.List;

public class DefineTest {
    @Test
    public void defineTest1() {
        ExecutionContext context = new ExecutionContext();
        List<String> args = new ArrayList<>();
        args.add("a");
        args.add("5");
        ParameterCommand command = new Define();
        command.execute(args, context);
        Assertions.assertEquals(5.0, context.getParameters().get("a"));
    }

    @Test
    public void defineExceptionTest1() {
        ExecutionContext context = new ExecutionContext();
        List<String> args = new ArrayList<>();
        args.add("a");
        ParameterCommand command = new Define();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            command.execute(args, context);
        });
    }

    @Test
    public void defineExceptionTest2() {
        ExecutionContext context = new ExecutionContext();
        List<String> args = new ArrayList<>();
        args.add("25");
        args.add("25");
        ParameterCommand command = new Define();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            command.execute(args, context);
        });
    }

    @Test
    public void defineExceptionTest3() {
        ExecutionContext context = new ExecutionContext();
        List<String> args = new ArrayList<>();
        args.add("25");
        args.add("25");
        ParameterCommand command = new Define();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            command.execute(args, context);
        });
    }

    @Test
    public void defineExceptionTest4() {
        ExecutionContext context = new ExecutionContext();
        ParameterCommand command = new Define();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            command.execute(null, context);
        });
    }

//    @Test
//    public void defineTest2() throws InvalidArgumentException, InvalidParameterNameException {
//        ExecutionContext context = ExecutionContext.init();
//        Define define = new Define();
//        String arg = "abc -25";
//        StackCalculator.executeCommand(define, arg, context);
//        Assertions.assertEquals(-25, context.mapGet("abc"));
//    }
//
//    @Test
//    public void defineTest3() throws InvalidArgumentException, InvalidParameterNameException {
//        ExecutionContext context = ExecutionContext.init();
//        Define define = new Define();
//        String arg = "a";
//        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
//            StackCalculator.executeCommand(define, arg, context);
//        });
//    }
//
//    @Test
//    public void defineTest4() throws InvalidArgumentException, InvalidParameterNameException {
//        ExecutionContext context = ExecutionContext.init();
//        Define define = new Define();
//        String arg = "25 25";
//        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
//            StackCalculator.executeCommand(define, arg, context);
//        });
//    }
//
//    @Test
//    public void defineTest5() throws InvalidArgumentException, InvalidParameterNameException {
//        ExecutionContext context = ExecutionContext.init();
//        Define define = new Define();
//        String arg = "";
//        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () -> {
//            StackCalculator.executeCommand(define, arg, context);
//        });
//    }
}
