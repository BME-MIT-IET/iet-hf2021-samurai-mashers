import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.company.StorageProblem;
import com.company.Column;
import com.company.Package;

public class InputTest {
    private StorageProblem problem;

    @BeforeEach
    public void setup(){
        problem = new StorageProblem();
    }

    @Test
    @DisplayName("Test input from ArrayList")
    public void testInputFromArrayList() {
        // Arrange
        ArrayList<Integer> input = new ArrayList<>( Arrays.asList(5, 7, 2, 7, 2, 2, 3, 4, 4, 2, 3, 2, 1, 2, 2, 5, 2, 2, 2, 1, 3, 1));
        // Act
        problem.GetInputFromIntArrayList(input);
        // Assert
        assertEquals(5, problem.storage.y, "Storage length is incorrect");
        assertEquals(7, problem.storage.x, "Storage width is incorrect");
        assertEquals(2, problem.storage.columns.size(), "Columns number is incorrect");
        assertEquals(7, problem.packages.size(), "The number of packages is incorrect");
        
        assertEquals(new Column(2,2), problem.storage.columns.get(0), "Column at index 0 is incorrect");
        assertEquals(new Column(4,3), problem.storage.columns.get(1), "Column at index 1 is incorrect");
        
        assertEquals(new Package(2,4,1), problem.packages.get(0), "Package with id 1 is incorrect");
        assertEquals(new Package(2,3,2), problem.packages.get(1), "Package with id 2 is incorrect");
        assertEquals(new Package(2,1,3), problem.packages.get(2), "Package with id 3 is incorrect");
        assertEquals(new Package(5,2,4), problem.packages.get(3), "Package with id 4 is incorrect");
        assertEquals(new Package(2,2,5), problem.packages.get(4), "Package with id 5 is incorrect");
        assertEquals(new Package(1,2,6), problem.packages.get(5), "Package with id 6 is incorrect");
        assertEquals(new Package(1,3,7), problem.packages.get(6), "Package with id 7 is incorrect");
    }

    @Test
    @DisplayName("Test input from Console")
    public void GetInputFromConsoleTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(
            "6\t6\n6\n13\n4\t3\n3\t2\n5\t5\n3\t2\n3\t3\n5\t2\n3\t6\n1\t1\n1\t2\n1\t6\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1".getBytes());
        System.setIn(in);
        problem.GetInputFromConsole();
        assertEquals(6, problem.storage.x, "Storage width is incorrect");
        assertEquals(6, problem.storage.y, "Storage length is incorrect");
        assertEquals(6, problem.storage.columns.size(), "Columns number is incorrect");
        assertEquals(13, problem.packages.size(), "The number of packages is incorrect");

        assertEquals(new Column(3,4), problem.storage.columns.get(0), "Column at index 0 is incorrect");
        assertEquals(new Column(2,3), problem.storage.columns.get(1), "Column at index 1 is incorrect");
        assertEquals(new Column(5,5), problem.storage.columns.get(2), "Column at index 2 is incorrect");
        
        assertEquals(new Package(6,3,1), problem.packages.get(0), "Package with id 1 is incorrect");
        assertEquals(new Package(1,1,2), problem.packages.get(1), "Package with id 2 is incorrect");
        assertEquals(new Package(2,1,3), problem.packages.get(2), "Package with id 3 is incorrect");
        
    }
}

