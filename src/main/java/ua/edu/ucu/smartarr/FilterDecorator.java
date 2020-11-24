package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private final MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;

        applyPredicate(this.smartArray);
    }

    private void applyPredicate(SmartArray smartArray) {
        Object[] array = smartArray.toArray();

        int counter = 0;
        for(Object element: array) {
            if (predicate.test(element)) {
                counter++;
            }
        }

        Object[] newArray = new Object[counter];
        int index = 0;
        for (Object element: array) {
            if (predicate.test(element)) {
                newArray[index++] = element;
            }
        }
        this.smartArray = new BaseArray(newArray);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator is used.";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
