public class teste {
  public static void main(String[] args) {

    BinarySearchST<String, Integer> tab = new BinarySearchST<>(15);

    tab.put("Gui", 100);
    tab.put("marcos", 90);
    tab.put("julio", 19);

    System.out.println(tab.get("Gui"));
    System.out.println(tab.get("julio"));

  }

}
