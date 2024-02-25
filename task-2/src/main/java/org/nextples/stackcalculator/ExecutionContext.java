package org.nextples.stackcalculator;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class ExecutionContext {
    private final Stack<Double> stack;
    private final HashMap<String, Double> parameters;

    public ExecutionContext() {
        this.stack = new Stack<>();
        this.parameters = new HashMap<>();
    }

//    public static ExecutionContext init() {
//        if(instance == null) {
//            instance = new ExecutionContext();
//            stack = new Stack<>();
//            map = new HashMap<>();
//        }
//        return instance;
//    }

    public Stack getStack() {
        return stack;
    }

    public HashMap getParameters() {
        return parameters;
    }

//    public double stackPeek() throws EmptyStackException {
//        return stack.peek();
//    }
//
//    public void stackPop() throws EmptyStackException {
//        stack.pop();
//    }
//
//    public void stackPush(double val) {
//        stack.push(val);
//    }
//
//    public double mapGet(String key) {
//        return parameters.get(key);
//    }
//
//    public void mapPut(String key, double val) {
//        parameters.put(key, val);
//    }

}
