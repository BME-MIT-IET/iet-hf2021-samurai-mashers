# Adding Behaviour Driven Development tests

## Adding Cucumber framework to project

Our goal was to add the necessary dependencies to use Cucumber and run the BDD tests when building the project. That is why we had to modify the build.gradle file
with the following changes:

![](./doc/cucumber_in_gradle.PNG)

As you can see we added cucumber into the dependencies, we added the configuration and a task for it as it was advised in the official documentation of Cucumber. The only
thing we had to modify was the path to the test file in the args parameter. Also we added a line at the end of the file that makes the build dependent on the Cucumber tests
so they will run during the build and build will fail if the tests fail.

## Defining the test cases in Gherkin 

The next step was to write the test cases and we would create the implementations for them later. We created 4 tests in Gherkin with the following code:

```gherkin
Feature: How can these packages be stored in this storage?
  The workers want to know how this is possible

  Scenario: We can fit them in storage
    Given the first set of packages
    When we run the program
    Then we get a correct result

  Scenario: We cannot fit them in storage
    Given the second set of packages
    When we run the program
    Then we get a correct result

  Scenario: We can fit them in storage
    Given the third set of packages
    When we run the program
    Then we get a correct result

  Scenario: We cannot fit them in storage
    Given the fourth set of packages
    When we run the program
    Then we get a correct result
```
The project only has one main feature so we only created one feature and for that feature we created the 4 tests. We have two different scenarios, one where we get a valid input
and we get a valid output after running the algorythm and another one where we get an invalid input and we get an invalid output. The steps are always the same except for the input
packages.

## Creating the implementation for the tests

For every test we wrote what happens at each step in the StepDefinitions.java class. In the "Given" step we initialized the input packages and the expected output, in the
"When" step we run the algorythm with the given input and finally in the "Then" step we checked if we got the output we expected.

```java
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
```

Also we created a test function here in the StepDefinition.java class because the program waits for standard input and the test function takes an InputStream and runs the
algorythm on that so we are able to test the program automatically from code.

## Overall experiences

Setting up Cucumber is not that hard and writing test is fairly easy as well after you get the hang of it. Gherkin offers a syntax that is understandable even for customers
and it is easy to see what scenarios are tested by which test. The only issue was that our project is not that big so BDD tests here do not that make that much sense.

    
