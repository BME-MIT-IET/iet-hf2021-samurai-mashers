import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import com.company.Storage;
import com.company.Package;
import com.company.Column;

public class PackageFitTest {
    private Storage storage;

    @BeforeEach
    public void setup(){
        storage = new Storage(7,7);
        storage.columns.add(new Column(3,2));
    }

    @Test
    @DisplayName("Package doesn't fit, not enough room in the storage (width)")
    public void testPacketDoesntFit_StickingOut_Width() {
        // Arrange
        Package pack = new Package(6,1,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 2, 3), "The package shouldn't fit");
    }

    @Test
    @DisplayName("Package doesn't fit, not enough room in the storage (length)")
    public void testPacketDoesntFit_StickingOut_Length() {
        // Arrange
        Package pack = new Package(1,5,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 4, 1), "The package shouldn't fit");
    }

    @Test
    @DisplayName("Package doesn't fit because its bigger than the storage")
    public void testPacketDoesntFit_Size() {
        // Arrange
        Package pack = new Package(5,5,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 2, 4), "The package shouldn't fit");
    }

    @Test
    @DisplayName("Package doesn't fit in place due to another package")
    public void testPacketDoesntFit_AnotherPackege() {
        // Arrange
        Package pack = new Package(3,2,2);
        storage.reserved[1][3] = 1;
        // Act & Assert
        assertFalse(storage.fit(pack, 0, 2), "The package shouldn't fit");
    }

    @Test
    @DisplayName("Package doesn't fit in place due to a column - its in the middle of the package")
    public void testPacketDoesntFit_Column() {
        // Arrange
        Package pack = new Package(2,2,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 2, 1), "The package shouldn't fit");
    }

    @Test
    @DisplayName("Package fits in several place (there's no disturbing columns)")
    public void testPacketFit() {
        // Arrange
        Package pack = new Package(2,2,2);
        
        // Act & Assert
        assertTrue(storage.fit(pack, 0, 0), "The package should fit in the storage"); //ihih
        assertTrue(storage.fit(pack, 2, 0), "The package should fit in the storage"); //iiih
        assertTrue(storage.fit(pack, 4, 0), "The package should fit in the storage"); //hiih
        assertTrue(storage.fit(pack, 0, 2), "The package should fit in the storage"); //ihhi
        assertTrue(storage.fit(pack, 2, 2), "The package should fit in the storage"); //iihi
        assertTrue(storage.fit(pack, 4, 2), "The package should fit in the storage"); //hihi        
    }
}