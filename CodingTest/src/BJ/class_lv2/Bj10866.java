package BJ.class_lv2;

import java.io.*;
import java.util.Objects;
import java.util.Optional;

public class Bj10866 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfCommands = Integer.parseInt(br.readLine());
            MyDeque<Integer> myDeque = new MyDeque<>();

            for (int i = 0; i < numberOfCommands; i++) {
                String command = br.readLine();
                if (command.startsWith("push_back")) {
                    myDeque.addLast(Integer.valueOf(command.substring(10)));

                } else if (command.startsWith("push_front")) {
                    myDeque.addFirst(Integer.valueOf(command.substring(11)));

                } else if (command.equals("back")) {
                    bw.write(myDeque.peekLast().orElse(-1) + "\n");

                } else if (command.equals("front")) {
                    bw.write(myDeque.peekFirst().orElse(-1) + "\n");

                }  else if (command.equals("empty")) {
                    bw.write(myDeque.isEmpty() + "\n");

                } else if (command.equals("pop_back")) {
                    bw.write(myDeque.getLast().orElse(-1) + "\n");

                } else if (command.equals("pop_front")) {
                    bw.write(myDeque.getFirst().orElse(-1) + "\n");

                } else if (command.equals("size")) {
                    bw.write(myDeque.size() + "\n");
                }
            }

            bw.flush();
        }
    }

    static class MyDeque<E> {
        private Node<E> first;
        private Node<E> last;
        private int size = 0;

        static class Node<E> {
            private final E value;
            private Node<E> prev;
            private Node<E> next;

            public Node(E value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node<?> node = (Node<?>) o;
                return Objects.equals(value, node.value) && Objects.equals(prev, node.prev) && Objects.equals(next, node.next);
            }
        }

        public void addFirst(E e) {
            Node<E> node = new Node<>(e);
            if (first == null) {
                // 첫번째 요소가 없으면 last도 null임
                first = node;
                last = node;
            } else {
                // 첫 번째 요소가 null이 아닌 경우, 기존의 첫 번째 요소 앞에 node 연결
                Node<E> next = first;
                next.prev = node;

                node.next = next;
                first = node;
            }

            size++;
        }

        public void addLast(E e) {
            Node<E> node = new Node<>(e);
            if (first == null) {
                // 첫 번째 요소가 없으면 last도 null임
                first = node;
                last = node;
            } else {
                Node<E> next = last;
                next.next = node;

                node.prev = next;
                last = node;
            }

            size++;
        }

        public Optional<E> getFirst() {
            if (first == null) {
                return Optional.empty();
            }

            if (first.equals(last)) {
                Optional<E> value = Optional.of(first.value);
                first = null;
                last = null;
                size--;
                return value;
            }

            Node<E> firstNode = first;
            Node<E> nextNode = first.next;

            firstNode.next = null;
            nextNode.prev = null;
            first = nextNode;
            size--;

            return Optional.of(firstNode.value);
        }

        public Optional<E> getLast() {
            if (last == null) {
                return Optional.empty();
            }

            if (first.equals(last)) {
                Optional<E> value = Optional.of(first.value);
                first = null;
                last = null;
                size--;
                return value;
            }

            Node<E> lastNode = last;
            Node<E> prevNode = last.prev;

            lastNode.prev = null;
            prevNode.next = null;
            last = prevNode;
            size--;

            return Optional.of(lastNode.value);
        }


        public Optional<E> peekFirst() {
            if (first == null) {
                return Optional.empty();
            }

            return Optional.of(first.value);
        }

        public Optional<E> peekLast() {
            if (last == null) {
                return Optional.empty();
            }

            return Optional.of(last.value);
        }

        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public int size() {
            return size;
        }
    }
}
