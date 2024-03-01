import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nextples.model.Define;
import org.nextples.model.ExecutionContext;
import org.nextples.model.ParameterCommand;
import org.nextples.model.Push;

import java.util.ArrayList;
import java.util.List;

public class PushTest {
    @Test
    public void pushTest1() {
        ExecutionContext context = new ExecutionContext();
        ParameterCommand command = new Push();
        List<String> args = new ArrayList<>();
        args.add("25.0");
        command.execute(args, context);
        Assertions.assertEquals(1, context.getStack().size());
        Assertions.assertEquals(25.0, context.getStack().peek());
    }

    @Test
    public void pushTest2() {
        ExecutionContext context = new ExecutionContext();
        List<String> args = new ArrayList<>();
        args.add("a");
        args.add("25.0");
        ParameterCommand command = new Define();
        command.execute(args, context);

        command = new Push();
        args = new ArrayList<>();
        args.add("a");
        command.execute(args, context);
        Assertions.assertEquals(1, context.getStack().size());
        Assertions.assertEquals(25.0, context.getStack().peek());
    }

    @Test
    public void pushIllegalAccessExceptionTest2() {
        ExecutionContext context = new ExecutionContext();

        ParameterCommand command = new Push();
        ArrayList<String> args = new ArrayList<>();
        args.add("a");
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            command.execute(args, context);
        });
    }
}
