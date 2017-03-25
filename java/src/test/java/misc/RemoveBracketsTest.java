package misc; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

/** 
* RemoveBrackets Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 25, 2017</pre> 
* @version 1.0 
*/ 
public class RemoveBracketsTest { 

  @Before
  public void before() throws Exception { 
  } 

  @After
  public void after() throws Exception { 
  } 

    /**
  *
  * Method: remove(String x)
  *
  */
  @Test
  public void testRemove() throws Exception {
  //TODO: Test goes here...
    String x_0 = "(1, (2,3) , (4, (5,6) , 7) )";
    String y_0 =  "1, 2,3 , 4, 5,6 , 7 ";
    String x_1 = "(1,) 2,3) , (4, (5,6 (, 7) )";
    String y_1 =  "error";
    Assert.assertEquals(y_0, RemoveBrackets.remove(x_0));
    Assert.assertEquals(y_1, RemoveBrackets.remove(x_1));


  }


} 
