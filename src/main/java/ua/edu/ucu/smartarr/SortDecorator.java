package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private final MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;

        selectionSort();
    }

    private void selectionSort() {
        Object[] array = smartArray.toArray();

        for (int i = 0; i < smartArray.size(); i++) {
            int minIndex = i;
            for (int j = i; j < smartArray.size(); j++) {
                if (comparator.compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            Object temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator is used.";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
