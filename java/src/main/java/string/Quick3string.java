package string;

/**
 * Created by kami.wm on 07/03/2017.
 *
 */
public class Quick3string {
  static int charAt(String a, int d) {
    return (d >= a.length()) ? -1 : a.charAt(d);
  }

  static void swap(String[] a, int pos_1, int pos_2) {
    String tmp = a[pos_1];
    a[pos_1] = a[pos_2];
    a[pos_2] = tmp;
  }

  static void sort(String[] a) {
    int N = a.length;
    sort(a, 0, N, 0);
  }

  // 这个函数用来, 每个字符串的第d位, 给字符串a[l:h)进行排序
  static void sort(String[] a, int l, int h, int d) {
    // 递归终止条件: 要排序的字符串只有一个
    if ( l + 1 >= h) {
      return;
    }
    // 对a[l:h)共h-l个字符串按照其第d位字符进行排序, 算法是快排

    // 头个字符串作为游标
    int cursor = charAt(a[l], d);
    int ls = l;
    int gt = h-1;
    int i = l+1;

    while (i <= gt) {
      int target = charAt(a[i], d);
      if (target < cursor ) {
        swap(a, ls++, i++);
      } else if(target > cursor) {
        swap(a, gt--, i);
      } else {
        i++;
      }
    }

    sort(a, l, ls, d);
    // 当没有下一位时, 停止向下一位递归
    if (cursor >= 0 ) sort(a, ls, gt+1, d+1);
    sort(a, gt+1, h, d);

  }
}
