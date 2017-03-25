package misc;

/**
 * Created by kami.wm on 25/03/2017.
 * 移除括号, 有不配对的报错
 *
 */
public class RemoveBrackets {

  public static String remove(String x) {
    StringBuilder y = new StringBuilder();
    Integer bracketsCount = 0;
    for (char a :x.toCharArray()) {
      if(a=='(') {
        bracketsCount++;
        continue;
      }
      if(a==')') {
        if (bracketsCount==0) {
          return "error";
        }
        bracketsCount--;
        continue;
      }
      y.append(a);
    }
    return y.toString();
  }

}
