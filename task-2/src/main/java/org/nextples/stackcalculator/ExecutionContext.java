package org.nextples.stackcalculator;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class ExecutionContext {
    private static ExecutionContext instance = null;
    private static Stack<Double> stack = null;
    private static HashMap<String, Double> map = null;

    private ExecutionContext() {}


    public static ExecutionContext init() {
        if(instance == null) {
            instance = new ExecutionContext();
            stack = new Stack<>();
            map = new HashMap<>();
        }
        return instance;
    }

    public double stackPeek() throws EmptyStackException {
        return stack.peek();
    }

    public void stackPop() throws EmptyStackException {
        stack.pop();
    }

    public void stackPush(double val) {
        stack.push(val);
    }

    public double mapGet(String key) {
        return map.get(key);
    }

    public void mapPut(String key, double val) {
        map.put(key, val);
    }

}
