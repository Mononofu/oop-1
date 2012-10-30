package myunit;

import java.util.List;
import java.math.BigDecimal;

public class AbstractTest {
  /* all methods here throw an exception if there condition is not fulfilled,
     which includes a helpful error message and is used to print the line in 
     which the error occurred.
     The condition itself is obvious from the method name and won't be explained
     individually.
   */
  public void assertEqual(Object a, Object b) {
    if(a == null && b == null) return;
    if(a == null || !a.equals(b)) throw new AssertException(String.format("%s wasn't equal to %s", a, b));
  }

  public void assertEqual(BigDecimal a, BigDecimal b) {
    if(a == null && b == null) return;
    if(a == null || a.compareTo(b) != 0) throw new AssertException(String.format("%s wasn't equal to %s", a, b));
  }

  public void assertNotEqual(Object a, Object b) {
    if(a == null && b != null) return;
    if(a == null || a.equals(b)) throw new AssertException(String.format("%s was equal to %s", a, b));
  }

  public void assertIs(Object a, Object b) {
    if(a != b) throw new AssertException(String.format("%s isn't %s (==)", a, b));
  }

  public void assertIsNot(Object a, Object b) {
    if(a == b) throw new AssertException(String.format("%s isn't %s (==)", a, b));
  }

  public <T> void assertIn(T a, List<T> b) {
    if(! b.contains(a)) throw new AssertException(String.format("%s is not in %s", a, b));
  }

  public <T> void assertNotIn(T a, List<T> b) {
    if(b.contains(a)) throw new AssertException(String.format("%s is in %s", a, b));
  }

  public void assertTrue(boolean cond) {
    if(!cond) throw new AssertException("assertion failed");
  }

  public void assertFalse(boolean cond) {
    if(cond) throw new AssertException("assertion failed");
  }

  public <T> void assertIsInstance(Object a, Class<T> cls) {
    if(!cls.isInstance(a)) throw new AssertException(
      String.format("%s is not an instance of %s", a, cls.getName()));
  }

  public <T> void assertIsNotInstance(Object a, Class<T> cls) {
    if(cls.isInstance(a)) throw new AssertException(
      String.format("%s is an instance of %s", a, cls.getName()));
  }
}