package immutables;

import java.util.Iterator;

public class MyLinkedList<Element> implements Iterable<Element>{

    private Node<Element> first;
    private Node<Element> last;
    private int size;

    @Override
    public Iterator<Element> iterator() {
        return new Iterator<>() {
            private Node<Element> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
                Node<Element> tmp = current;
                current = current.next;
                return tmp.value;
            }
        };
    }

    private static class Node<Element> {
        Element value;
        Node<Element> prev;
        Node<Element> next;

        public Node(Node<Element> prev, Element value, Node<Element> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(Element element) {
        Node<Element> node;
        if (first == null) {
            node = new Node<>(null, element, null);
            first = node;
        } else {
            node = new Node<>(last, element, null);
            last.next = node;
        }
        last = node;
        size++;
    }

    public int size() {
        return size;
    }

    private Node<Element> getNodeByIndex (int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public Element get(int index) {
       return getNodeByIndex(index).value;
    }

    public Element getFirst() {
        if (first == null) {
            System.out.print("Список пуст: ");
            return null;
        } else
            return first.value;
    }

    public void addFirst(Element element) {
        Node<Element> node;
        if (first == null) {
            node = new Node<>(null, element, null);
        } else {
            node = new Node<>(null, element, first);
            first.prev = node;
        }
        first = node;
        size++;
    }

    public void delete(int index) {
        Node<Element> deleteNode = getNodeByIndex(index);

        if (deleteNode.prev == null) {
            deleteNode = first.next;
            deleteNode.prev.next = null;
            first = deleteNode;
        } else {
            deleteNode.prev.next = deleteNode.next;
            deleteNode.next.prev = deleteNode.prev;
        }
        size--;
    }
}
