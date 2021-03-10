package immutables;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> strings = new MyLinkedList<>();

        strings.add("Один");
        strings.add("Два");
        strings.add("Три");
        strings.add("Четыре");
        strings.add("Пять");
        strings.add("Шесть");

        System.out.println(strings.size());
        System.out.println();
        strings.addFirst("Ноль");
        System.out.println(strings.get(0));
        System.out.println();

        for (int i = strings.size() - 1; i >= 0; i--) {
            System.out.print(strings.get(i) + " ");
        }

        System.out.println(strings.size());
        strings.delete(0);

        for (int i = strings.size() - 1; i >= 0; i--) {
            System.out.print(strings.get(i) + " ");
        }

        System.out.println();

        System.out.println(strings.size());

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        System.out.println(myLinkedList.getFirst());

        for (String s : strings) {
            System.out.println(s);
        }

    }
}
