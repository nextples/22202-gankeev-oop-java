package org.nextples.stackcalculator.command;

import static java.lang.Math.sqrt;
import org.nextples.stackcalculator.ExecutionContext;
import java.util.EmptyStackException;

public class Sqrt implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, EmptyStackException {
        double arg = context.stackPeek();
        context.stackPop();
        if (arg < 0) {
            throw new ArithmeticException("invalid extraction of the square root of " + arg);
        }
        else {
            double result = sqrt(arg);
            context.stackPush(result);
        }
    }
}
