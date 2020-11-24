package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private final Object[] baseArray;

    public BaseArray(Object[] objects) {
        this.baseArray = objects;
    }

    @Override
    public Object[] toArray() {
        return baseArray;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return baseArray.length;
    }
}
