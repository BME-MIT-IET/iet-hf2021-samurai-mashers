import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.company.Column;
import com.company.Package;
import com.company.Storage;
import com.company.StorageProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlgorythmTest {
    private StorageProblem problem;

    @BeforeEach
    public void setup() {
        problem = new StorageProblem();
        problem.storage = new Storage(3, 4);
        problem.packages = new ArrayList<Package>();
    }

    @Test
    @DisplayName("The algorythm is working properly")
    public void AlgorythmCheck() {
        problem.storage.columns.add(new Column(1, 1));
        problem.storage.columns.add(new Column(2, 2));

        problem.packages.add(new Package(2, 2, 1));
        problem.packages.add(new Package(1, 1, 2));
        problem.packages.add(new Package(2, 1, 3));
        problem.packages.add(new Package(1, 2, 4));
        problem.packages.add(new Package(1, 3, 5));

        problem.Solve();

        int[][] expected = new int[4][3];
        expected[0][0] = 5;
        expected[0][1] = 1;
        expected[0][2] = 1;
        expected[1][0] = 5;
        expected[1][1] = 1;
        expected[1][2] = 1;
        expected[2][0] = 5;
        expected[2][1] = 3;
        expected[2][2] = 3;
        expected[3][0] = 4;
        expected[3][1] = 4;
        expected[3][2] = 2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                assertEquals(expected[i][j], problem.storage.reserved[i][j], "The algorythm has an issue!");
        }
    }
}