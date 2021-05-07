import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import com.company.Storage;
import com.company.StorageProblem;

public class PrintTest {

	private OutputStream os = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(os);

	private StorageProblem problem = new StorageProblem();

	@Test
	@DisplayName("The print is correct")
	public void testStoragePrint() {
	
		System.setOut(ps);
		problem.storage = new Storage(3,3);

		problem.storage.reserved[0][0] = 5;
		problem.storage.reserved[0][1] = 1;
		problem.storage.reserved[0][2] = 4;
		problem.storage.reserved[1][0] = 5;
		problem.storage.reserved[1][1] = 2;
		problem.storage.reserved[1][2] = 6;
		problem.storage.reserved[2][0] = 5;
		problem.storage.reserved[2][1] = 3;
		problem.storage.reserved[2][2] = 7;

		problem.PrintStorage();
		assertEquals("5\t5\t5\n1\t2\t3\n4\t6\t7\n", os.toString(), "The print is incorrect");
	}
}
