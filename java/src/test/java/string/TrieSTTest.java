package string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* TrieST Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 30, 2017</pre> 
* @version 1.0 
*/ 
public class TrieSTTest { 

  @Before
  public void before() throws Exception { 
  } 

  @After
  public void after() throws Exception { 
  } 

    /** 
  * 
  * Method: get(String key) 
  * 
  */ 
  @Test
  public void testGet() throws Exception { 
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    Assert.assertEquals(trie.get("are"), "0");
    Assert.assertEquals(trie.get("by"), "1");
    Assert.assertEquals(trie.get("sea"), "2");
    Assert.assertEquals(trie.get("seashells"), "3");
    Assert.assertEquals(trie.get("sells"), "4");
    Assert.assertEquals(trie.get("she"), "5");
    Assert.assertEquals(trie.get("shells"), "6");
    Assert.assertEquals(trie.get("shore"), "7");
    Assert.assertEquals(trie.get("surely"), "8");
    Assert.assertEquals(trie.get("the"), "9");
    Assert.assertEquals(trie.get(""), "");

  }

  /** 
  * 
  * Method: put(String key, Value val) 
  * 
  */ 
  @Test
  public void testPut() throws Exception {
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    Assert.assertEquals(trie.get("are"), "0");
    Assert.assertEquals(trie.get("by"), "1");
    Assert.assertEquals(trie.get("sea"), "2");
    Assert.assertEquals(trie.get("seashells"), "3");
    Assert.assertEquals(trie.get("sells"), "4");
    Assert.assertEquals(trie.get("she"), "5");
    Assert.assertEquals(trie.get("shells"), "6");
    Assert.assertEquals(trie.get("shore"), "7");
    Assert.assertEquals(trie.get("surely"), "8");
    Assert.assertEquals(trie.get("the"), "9");
    Assert.assertEquals(trie.get(""), "");
    Assert.assertEquals(trie.get("ar"), null);
    Assert.assertEquals(trie.get("seas"), null);
    Assert.assertEquals(trie.get("he"), null);
  }

  /** 
  * 
  * Method: delete(String key) 
  * 
  */ 
  @Test
  public void testDelete() throws Exception { 
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    trie.delete("are");
    trie.delete("by");
    trie.delete("seas");
    trie.delete("sea");
    trie.delete("");
    Assert.assertEquals(trie.get("are"), null);
    Assert.assertEquals(trie.get("ar"), null);
    Assert.assertEquals(trie.get("by"), null);
    Assert.assertEquals(trie.get("sea"), null);
    Assert.assertEquals(trie.get("seashells"), "3");
    Assert.assertEquals(trie.get("seas"), null);
    Assert.assertEquals(trie.get("sells"), "4");
    Assert.assertEquals(trie.get("she"), "5");
    Assert.assertEquals(trie.get("shells"), "6");
    Assert.assertEquals(trie.get("shore"), "7");
    Assert.assertEquals(trie.get("surely"), "8");
    Assert.assertEquals(trie.get("the"), "9");
    Assert.assertEquals(trie.get("he"), null);
    Assert.assertEquals(trie.get(""), null);
  }

  /** 
  * 
  * Method: keys() 
  * 
  */ 
  @Test
  public void testKeys() throws Exception {
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    List<String> actualKeys = new ArrayList<String>(
        Arrays.asList("are", "by", "sea","seashells", "sells", "she", "shells", "shore", "surely", "the", ""));
    List<String> keys = trie.keys();
    for (String key: actualKeys) {
      Assert.assertTrue("keys: " + key, keys.contains(key));
    }
  }

  /** 
  * 
  * Method: keysWithPrefix(String pre) 
  * 
  */ 
  @Test
  public void testKeysWithPrefix() throws Exception { 
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");

    List<String> actualKeys = new ArrayList<String>(Arrays.asList("sea","seashells", "sells"));
    List<String> keys = trie.keysWithPrefix("se");
    Assert.assertArrayEquals(keys.toArray(), actualKeys.toArray());
  }

  /** 
  * 
  * Method: keysThatMatch(String pat) 
  * 
  */ 
  @Test
  public void testKeysThatMatch() throws Exception { 
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    List<String> actualKeys = new ArrayList<String>(Arrays.asList("shells", "surely"));
    List<String> keys = trie.keysThatMatch("s...l.");
    Assert.assertArrayEquals(keys.toArray(), actualKeys.toArray());
  }

  /** 
  * 
  * Method: longestPrefixOf(String s) 
  * 
  */ 
  @Test
  public void testLongestPrefixOf() throws Exception { 
    TrieST<String> trie = new TrieST<String>();
    trie.put("are", "0");
    trie.put("by", "1");
    trie.put("sea","2");
    trie.put("seashells","3");
    trie.put("sells","4");
    trie.put("she", "5");
    trie.put("shells", "6");
    trie.put("shore", "7");
    trie.put("surely", "8");
    trie.put("the", "9");
    trie.put("", "");
    Assert.assertEquals(trie.longestPrefixOf("are"), "are");
    Assert.assertEquals(trie.longestPrefixOf("the tiger"), "the");
    Assert.assertEquals(trie.longestPrefixOf("sh"), "");
  }

}
