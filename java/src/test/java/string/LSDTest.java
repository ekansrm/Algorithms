package string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;

/**
 * LSD Tester.
 *
 * @author <Authors name>
 * @since <pre>Mar 4, 2017</pre>
 * @version 1.0
 */
public class LSDTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   *
   * Method: sort(String[] list, int width)
   *
   */
  @Test
  public void testSort() throws Exception {
    ArrayList<String> list = new ArrayList<String>();
    list.add("00");
    list.add("09");
    list.add("10");
    list.add("20");
    list.add("21");

    ArrayList<String> shuffledList = new ArrayList<String>(list);
    Collections.shuffle(shuffledList);
    String[] target = shuffledList.toArray(new String[list.size()]);

//    Utils.printStringList(list.toArray(new String[list.size()]));
    LSD.sort(target, 2);
//    Utils.printStringList(target);

    Assert.assertArrayEquals("打乱检查", list.toArray(), target);

  }

} 
