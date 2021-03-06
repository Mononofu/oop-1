package test;

import java.util.List;
import java.util.ArrayList;

// all test classes should extend AbstractTest to get useful utility methods
public class SampleTest extends AbstractTest {
  List<String> l;

  @BeforeClass
  public void MySetupMethod() {
    l = new ArrayList<String>();
    l.add("hallo");
    l.add("world");
  }

  // all tests need to be annotated with @UnitTest and have a void () signature
  @UnitTest
  public void IsOneEqualToTwo() {
    assertEqual(1, 1);            // one such utility method is assertEqual, which
  }                               // prints its arguments if the assertion fails

  @UnitTest
  public void myOtherTest() {
    assertEqual(3, 3);
    assertNotEqual(null, 2);
  }

  @UnitTest
  public void CheckStringAddition() {
    String str = new String("ha");
    String str2 = new String("llo");
    assertEqual(str + str2, "hallo");
  }

  @UnitTest
  public void StringAdditionIsNotSameObject() {
    String str = new String("ha");
    String str2 = new String("llo");
    assertIsNot(str + str2, "hallo");       // there's also assertIs(a, b)
  }

  @UnitTest
  public void ElementShouldBeInList() {
    // l is created in the setup method MySetupMethod
    assertIn("hallo", l);
  }

  @UnitTest
  public void aFailingTestAgain () {
    assertTrue(true);
  }

  @UnitTest
  public void StringShouldntBeAnInteger () {
    assertIsNotInstance("hello", Integer.class);
  }

  @UnitTest
  @AssertThrows(exception = RuntimeException.class)
  public void TestThatThrows() {
    int i = 0;
    throw new RuntimeException("da test");
  }
  

  // if a method isn't annotated, it will never run
  public void otherMethod() {
    System.out.println("I won't run");
  }
}