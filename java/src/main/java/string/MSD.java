package string;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by kami.wm on 06/03/2017.
 *
 */
class MSD {
  static int arrayLengthTresholdForMSD = 5; // 如果要排序的子字符串的长度小于这个, 切换至插入排序
  static int radix = 256;
  static String[] aux;

  static int charAt(String a, int d) {
    return (d >= a.length()) ? -1 : a.charAt(d);
  }

  static void sort(String[] a) {
    int N = a.length;
    aux = new String[N];
    sort(a, 0, N, 0);

  }

  // 这个函数用来, 每个字符串的第d位, 给字符串a[l:h)进行排序
  static void sort(String[] a, int l, int h, int d) {

    // 如果分组小于5个, 进行插入排序
    if (l + arrayLengthTresholdForMSD >= h) {
      insertionSort(a, l, h, d);
      return;
    }

    // c_char --> count[c_char+1]
    int[] count = new int[radix+2];
    for (int i = l; i < h ; i++) {
      count[charAt(a[i], d) + 2] += 1;
    }
    for (int i = 0; i < radix+1; i++) {
      count[i+1] += count[i];
    }

    for (int i = l; i < h; i++) {
//      System.out.printf("%d: %s", i, a[i]);
//      System.out.printf("--->");
//      System.out.printf("%d", count[charAt(a[i], d)+1]);
//      System.out.println();
      aux[count[charAt(a[i], d)+1]] = a[i];
      count[charAt(a[i], d)+1]++;
    }

    System.arraycopy(aux, 0, a, l, h - l);

    // 递归地一每个字符为键进行排序
    for (int i = 0; i < radix; i++){
      if(count[i] == count[i + 1]) {
        continue;
      }
      sort(a, l + count[i], l + count[i + 1], d + 1);
    }
  }

  // 这个函数用来, 从每个字符串的位置d开始, 对字符串数组a[l:h) 插入排序
  static void insertionSort(String[] a, int l, int h, int d) {
    for (int i = l; i < h; i++) {
      // a[l:i-1]是有序的. 那么令 j = i, 对于a[i](a[j] , j = i)而言, 和a[i-1](a[j-1] , j = i)而比较, 如果a[i]更小, 那么两者
      // 交换. 然后, a[i-1]和a[i-2](a[j], a[j-1], j = j - 1)比较, 如此类推, 直到a[j] 比 a[j-1]大
      for (int j = i; j > l && less(a[j], a[j-1], d); j--) {
        if (less(a[j], a[j-1], d)) {
          String tmp = a[j-1];
          a[j-1] = a[j];
          a[j] = tmp;
        }
      }
    }
  }

  // 比较字符串a[d:], b[d:] 的大小
  static boolean less(String a, String b, int d) {
    return a.substring(d).compareTo(b.substring(d)) < 0;
  }

}
