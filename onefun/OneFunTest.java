// @author Pratyush Singh
/**
 * A unit test for one method that will help in the next
 * project because you need compareTo and compareTo is so weird
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class OneFunTest {

  OneFun oneFun = new OneFun();

  @Test
  public void testLexocographicallyFirst() {
    assertEquals("", oneFun.first("", "A"));
    assertEquals("0", oneFun.first("A", "0"));
    assertEquals("1", oneFun.first("1", "A"));
    assertEquals("?", oneFun.first("?", "A"));
    assertEquals("A", oneFun.first("A", "a"));
    assertEquals("Z", oneFun.first("Z", "a"));
    assertEquals("abc", oneFun.first("abc", "abc"));
    assertEquals("abc", oneFun.first("abc ", "abc"));
    assertEquals("abc", oneFun.first("abc", "abcd"));
  }
}