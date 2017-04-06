package string; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;

/** 
* MSD Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 6, 2017</pre> 
* @version 1.0 
*/ 
public class MSDTest { 

  @Before
  public void before() throws Exception { 
  } 

  @After
  public void after() throws Exception { 
  } 

    /** 
  * 
  * Method: sort(String[] a) 
  * 
  */ 
  @Test
  public void testSort() throws Exception {

    ArrayList<String> list = Utils.testCase_1();

    ArrayList<String> shuffledList = new ArrayList<String>(list);
    Collections.shuffle(shuffledList);
    String[] target = shuffledList.toArray(new String[list.size()]);

//    Utils.printStringList(list.toArray(new String[list.size()]));
    MSD.sort(target);
//    Utils.printStringList(target);

    Assert.assertArrayEquals("排序后检查", list.toArray(), target);

  }

} 
