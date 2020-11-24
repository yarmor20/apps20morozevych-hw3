package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private final MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;

        applyFunction();
    }

    private void applyFunction() {
        Object[] array = this.smartArray.toArray();

        for (int i = 0; i < smartArray.size(); i++) {
            array[i] = function.apply(array[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator is used.";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
