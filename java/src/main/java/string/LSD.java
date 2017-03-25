package string;

/**
 * Created by ekansrm on 3/4/17.
 *
 */
class LSD {

  private static int R = 256;

  static void sort(String[] a, int w) {

    String[] aux = new String[a.length];

    for (int i = w-1; i >= 0  ; i--) {

      int[] count = new int[R+1];

      for (String anA : a) {
        count[anA.charAt(i) + 1] += 1;
      }

      for (int j = 0; j < R ; j++) {
        count[j+1] += count[j];
      }

      for (String anA : a) {
        aux[count[anA.charAt(i)]++] = anA;
      }

      System.arraycopy(aux, 0, a, 0, a.length);

    }


  }

}
