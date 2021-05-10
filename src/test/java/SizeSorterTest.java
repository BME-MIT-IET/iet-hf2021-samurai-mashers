import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.company.SizeSorter;
import com.company.Package;

public class SizeSorterTest {
    private static SizeSorter sorter;

    @BeforeAll
    public static void setup(){
        sorter = new SizeSorter();
    }

    @Test
    @DisplayName("Test SizeSorter - equal Packages")
    public void testSizeSorter_EqualPackages() {
        // Arrange
        Package p1 = new Package(2,5,4);
        Package p2 = new Package(5,2,1);
        // Act & Assert
        assertEquals(0, sorter.compare(p1, p2), "The function should return with 0");
    }

    @Test
    @DisplayName("Test SizeSorter - first Package is smaller")
    public void testSizeSorter_FirstPackageSmaller() {
        // Arrange
        Package p1 = new Package(1,4,3);
        Package p2 = new Package(7,8,2);
        // Act & Assert
        assertTrue(sorter.compare(p1, p2) > 0, "The function should return with positive result");
    }

    @Test
    @DisplayName("Test SizeSorter - second Package is smaller")
    public void testSizeSorter_SecondPackageSmaller() {
        // Arrange
        Package p1 = new Package(6,3,6);
        Package p2 = new Package(3,2,4);
        // Act & Assert
        assertTrue(sorter.compare(p1, p2) < 0, "The function should return with negative result");
    }
}
