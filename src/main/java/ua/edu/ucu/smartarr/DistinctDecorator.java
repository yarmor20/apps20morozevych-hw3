package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        removeDuplicates();
    }

    private void removeDuplicates() {
        Object[] array = this.smartArray.toArray();
        Object[] newArray = new Object[this.smartArray.size()];

        int counter = 0;
        for (Object obj: array) {
            if (isUnique(newArray, obj)) {
                newArray[counter++] = obj;
            }
        }
        this.smartArray = new BaseArray(Arrays.copyOf(newArray, counter));
    }

    private boolean isUnique(Object[] array, Object object) {
        for (Object obj: array) {
            if (equals(obj, object)) {
                return false;
            }
        }
        return true;
    }

    private boolean equals(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null)
            return false;
        return Objects.equals(obj1.toString(), obj2.toString());
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator is used.";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
