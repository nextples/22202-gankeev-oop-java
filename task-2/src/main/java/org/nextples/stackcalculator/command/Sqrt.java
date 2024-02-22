package org.nextples.stackcalculator.command;

import static java.lang.Math.sqrt;
import org.nextples.stackcalculator.ExecutionContext;

public class Sqrt implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException {
        double arg = context.stackPeek();
        context.stackPop();
        if (arg < 0) {
            throw new ArithmeticException();
        }
        else {
            double result = sqrt(arg);
            context.stackPush(result);
        }
    }
}
