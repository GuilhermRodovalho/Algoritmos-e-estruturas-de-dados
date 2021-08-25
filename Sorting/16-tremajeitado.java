// Just a bubble sort with a counter

import java.util.Scanner;

class bubbleCount {

  public int calcular(int[] array) {
    return bubbleCount.count(array);
  }

  private static int count(int[] array) {
    if (array == null)
      return 0;

    int res = 0;

    boolean ordenado;

    do {
      ordenado = true;

      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
          int temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;

          ordenado = false;
          res++;
        }
      }

    } while (!ordenado);

    return res;
  }

}

class Main {

  public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);

    bubbleCount obj = new bubbleCount();

    int casosteste = reader.nextInt();

    while (casosteste > 0) {
      int vagoes = reader.nextInt();

      int[] trem = new int[vagoes];

      for (int i = 0; i < vagoes; i++) {
        trem[i] = reader.nextInt();
      }

      System.out.println("A quantidade ajeitamentos deve ser " + obj.calcular(trem) + ".");

      casosteste--;
    }

    reader.close();

  }
}
