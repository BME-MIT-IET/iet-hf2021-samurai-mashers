import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.company.Storage;
import com.company.Package;


public class RowCountTest {
    private Storage storage;

    @BeforeEach
    public void setup(){
        storage = new Storage(5,5);
        for(int x = 2; x < 5; x++){
            for (int y = 0; y < 2; y++){
                storage.reserved[x][y] = 1;
            }
        }

    }

    @Test
    @DisplayName("Count reserved rows in storage with new package")
    public void testRowCount_NewPackage() {
        // Arrange
        Package pack = new Package(2,2,1);
        // Act & Assert
        assertEquals(3, storage.RowCount(pack, 0, 1), "There should be 3 rows where there is already a package");
    }
    
}
