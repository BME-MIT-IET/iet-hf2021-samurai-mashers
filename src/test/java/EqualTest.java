import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.company.Column;
import com.company.Package;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EqualTest {

    @Test
    @DisplayName("Package Comparisons")
    public void PackageEqualsTest() {
        Package pack = new Package(2,3,1);
        Column column = new Column(1,1);

        assertEquals(pack, pack, "The two packages should be equal, because they are the same!");
        assertEquals(new Package(2,3,1), pack, "The two packages should be equal, because they have the same parameters!");
        assertNotEquals(new Package(2,6,2), pack, "Only the length is equal, the width and the id aren't!");
        assertNotEquals(new Package(3,3,5), pack, "Only the width is equal, the length and the id aren't!");
        assertNotEquals(new Package(2,3,4), pack, "Only the width and the length are equal, the id isn't!");
        assertNotEquals(new Package(5,4,1), pack, "Only the id is equal, the length and the width aren't!");
        assertNotEquals(new Package(4,4,3), pack, "They have different parameters!");
        assertNotEquals(pack, column, "A column isn't a package!");
    }

    @Test
    @DisplayName("Column Comparisons")
    public void ColumnEqualsTest() {
        Package pack = new Package(2,3,1);
        Column column = new Column(1,1);

        assertEquals(column, column, "The two columns should be equal, because they are the same!");
        assertEquals(new Column(1,1), column, "The two columns should be equal, because they have the same parameters!");
        assertNotEquals(new Column(1,3), column, "Only the x coordinate is equal, the y isn't!");
        assertNotEquals(new Column(2,1), column, "Only the y coordinate is equal, the x isn't!");
        assertNotEquals(new Column(2,3), column, "They have different parameters!");
        assertNotEquals(column, pack, "A package isn't a column!");
    }
}