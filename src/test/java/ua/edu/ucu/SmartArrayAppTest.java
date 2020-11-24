package ua.edu.ucu;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        
        Integer[] res = 
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};
        
        assertArrayEquals(expectedRes, res);        
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
            new Student("Ivar", "Grimstad", 3.9, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Antons", "Kranga", 4.0, 2),
            new Student("Burr", "Sutter", 4.2, 2),
            new Student("Philipp", "Krenn", 4.3, 3),
            new Student("Tomasz", "Borek", 4.1, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames = 
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }
}