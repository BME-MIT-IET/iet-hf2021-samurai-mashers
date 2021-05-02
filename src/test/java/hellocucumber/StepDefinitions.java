package hellocucumber;

import com.company.Column;
import com.company.Package;
import com.company.Storage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    String input;
    String expectedOutput;
    String actualOutput;

    private String test(InputStream inputStream){
        Scanner input = new Scanner(inputStream);
        int length;
        int width;
        int colcount;
        int packagecount;
        ArrayList<Package> packages = new ArrayList<Package>();
        length = input.nextInt();
        width = input.nextInt();
        Storage storage = new Storage(length, width);
        colcount = input.nextInt();
        packagecount = input.nextInt();
        int colx;
        int coly;
        for(int i = 0; i < colcount; i++){
            coly = input.nextInt();
            colx = input.nextInt();
            storage.columns.add(new Column(colx, coly));
        }
        int pacx;
        int pacy;
        for(int i = 0; i < packagecount; i++){
            pacy = input.nextInt();
            pacx = input.nextInt();
            packages.add(new Package(pacx, pacy, i+1));
        }

        String outputString = "";
        try {
            storage.Algorythm(packages);

            for (int i = 0; i < storage.y; i++){
                for (int j = 0; j < storage.x; j++){
                    if(j != storage.x-1)
                        outputString += (storage.reserved[j][i] + "\t");
                    else if(j == storage.x-1)
                        outputString += (storage.reserved[j][i] + "\n");
                }
            }

        }catch (Exception exception){
            outputString = "Cannot fit packages";
        }

        return outputString;
    }

    @Given("the first set of packages")
    public void theFirstSetOfPackages(){
        expectedOutput = "4\t4\t4\t4\t4\t5\t5\n4\t4\t4\t4\t4\t5\t5\n1\t1\t1\t1\t2\t2\t2\n1\t1\t1\t1\t2\t2\t2\n7\t7\t7\t3\t3\t6\t6\n";
        input = "5\t7\n2\n7\n2\t2\n3\t4\n4\t2\n3\t2\n1\t2\n2\t5\n2\t2\n2\t1\n3\t1";
    }

    @When("we run the program")
    public void weRunTheProgram(){
        InputStream fakeInputStream = new ByteArrayInputStream(input.getBytes());
        actualOutput = test(fakeInputStream);
    }

    @Then("we get a correct result")
    public void weGetACorrectArrangement(){
        assertEquals(expectedOutput, actualOutput);
    }

    @Given("the second set of packages")
    public void theSecondSetOfPackages(){
        expectedOutput = "Cannot fit packages";
        input = "5\t7\n2\n7\n2\t2\n3\t4\n4\t2\n3\t2\n1\t2\n2\t5\n2\t2\n2\t1\n3\t2";
    }

    @Given("the third set of packages")
    public void theThirdSetOfPackages(){
        expectedOutput = "9\t9\t9\t9\t2\t3\t5\t6\t7\n4\t10\t10\t10\t10\t10\t10\t10\t1\n4\t10\t10\t10\t10\t10\t10\t10\t1\n4\t10\t10\t10\t10\t10\t10\t10\t1\n4\t10\t10\t10\t10\t10\t10\t10\t1\n4\t10\t10\t10\t10\t10\t10\t10\t1\n4\t10\t10\t10\t10\t10\t10\t10\t14\n4\t10\t10\t10\t10\t10\t10\t10\t14\n8\t11\t12\t13\t15\t16\t17\t18\t19\n";
        input = "9\t9\n9\n19\n8\t1\n8\t1\n7\t1\n8\t2\n8\t5\n7\t8\n8\t6\n4\t8\n1\t5\n5\t1\n1\t1\n1\t1\n1\t7\n1\t1\n1\t1\n1\t1\n1\t1\n4\t1\n7\t7\n1\t1\n1\t1\n1\t1\n1\t2\n1\t1\n1\t1\n1\t1\n1\t1\n1\t1";
    }

    @Given("the fourth set of packages")
    public void theFourthSetOfPackages(){
        expectedOutput = "Cannot fit packages";
        input = "3\t9\n9\n19\n8\t1\n8\t1\n7\t1\n8\t2\n8\t5\n7\t8\n8\t6\n4\t8\n1\t5\n5\t1\n1\t1\n1\t1\n1\t7\n1\t1\n1\t1\n1\t1\n1\t1\n4\t1\n7\t7\n1\t1\n1\t1\n1\t1\n1\t2\n1\t1\n1\t1\n1\t1\n1\t12\n1\t10";
    }

}
