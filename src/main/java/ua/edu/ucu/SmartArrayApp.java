package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = t -> ((Integer) t) > 0;
        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);
        MyFunction func = t -> 2 * ((Integer) t);

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);   // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp);    // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func);    // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        SmartArray sa = new BaseArray(students);

        // Get rid of duplicates
        sa = new DistinctDecorator(sa);

        // Get rid of students that are not on the 2nd course
        MyPredicate pr = t -> {
            Student student = (Student) t;
            return student.getYear() == 2;
        };

        sa = new FilterDecorator(sa, pr);

        // Get rid of students with GPA less than 4
        MyPredicate pr2 = t -> {
            Student student = (Student) t;
            return student.getGPA() >= 4;
        };

        sa = new FilterDecorator(sa, pr2);

        // Sort the students by surnames using the following comparator
        MyComparator cmp = (o1, o2) -> {
            String surname1 = ((Student)o1).getSurname();
            String surname2 = ((Student)o2).getSurname();

            for (int i = 0; i < surname1.length(); i++) {
                int result = ((int) surname1.charAt(i)) - ((int) surname2.charAt(i));
                if (result > 0) {return 1;}
                if (result < 0) {return -1;}
            }
            return Integer.compare(surname1.length(), surname2.length());
        };

        sa = new SortDecorator(sa, cmp);

        // Create an array of Surname-Name representation of students
        Object[] result = sa.toArray();
        String[] str = new String[result.length];

        int counter = 0;
        for (Object student: result) {
            str[counter++] = ((Student)student).getSurname() + " " + ((Student)student).getName();
        }
        return str;
    }
}
