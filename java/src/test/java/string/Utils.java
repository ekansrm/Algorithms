package string;

import java.util.ArrayList;

/**
 * Created by kami.wm on 07/03/2017.
 */
public class Utils {

  public static void printStringList (String[] a) {

    for(String i: a) {
      System.out.print(i + ' ');
    }
    System.out.print('\n');
  }

  public static ArrayList<String> testCase_1 () {
    ArrayList<String> list = new ArrayList<String>();
    list.add("are");
    list.add("by");
    list.add("sea");
    list.add("seashells");
    list.add("seashells");
    list.add("sells");
    list.add("sells");
    list.add("she");
    list.add("she");
    list.add("shells");
    list.add("shore");
    list.add("surely");
    list.add("the");
    list.add("the");
    return list;
  }

}
