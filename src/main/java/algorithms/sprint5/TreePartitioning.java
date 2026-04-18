import java.util.ArrayList;
import java.util.List;

public class TreePartitioning {


    /*
     * Принцип работы алгоритма:
     * Разбиваем BST по порядковой статистике.
     * Для текущей вершины считаем размер левого поддерева:
     * 1) если k <= size(left), то все k наименьших элементов лежат в левом поддереве,
     *    а текущая вершина должна попасть во второе дерево;
     * 2) иначе в первое дерево точно входят всё левое поддерево и текущая вершина,
     *    значит, остаётся отделить ещё k - size(left) - 1 вершин из правого поддерева.
     *
     * Чтобы не получить переполнение стека на вырожденном дереве, алгоритм сделан итеративно:
     * сначала спускаемся вниз по одному пути, запоминая вершины и направление перехода,
     * затем поднимаемся обратно и собираем два дерева, пересчитывая size.
     *
     * Почему алгоритм корректен:
     * На каждом шаге решение принимается по точному числу вершин, которые меньше текущей,
     * то есть по size(left). Поэтому мы всегда правильно определяем, должна ли текущая
     * вершина попасть в первые k элементов.
     *
     * При обратной сборке:
     * - если спускались влево, то текущая вершина и её правое поддерево относятся ко второму дереву;
     * - если спускались вправо, то текущая вершина и её левое поддерево относятся к первому дереву.
     *
     * Так как переподвешиваются только поддеревья вдоль одного пути, свойство BST сохраняется.
     * В итоге в первом дереве оказывается ровно k наименьших элементов, во втором — остальные.
     *
     * Временная сложность: O(h), где h — высота дерева.
     * Пространственная сложность: O(h) на хранение пути.
     */
    public static List<Node> split(Node root, int k) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Boolean> wentRight = new ArrayList<>();

        Node current = root;
        int need = k;

        while (current != null) {
            int leftSize = size(current.getLeft());
            if (need <= leftSize) {
                path.add(current);
                wentRight.add(false);
                current = current.getLeft();
            } else {
                path.add(current);
                wentRight.add(true);
                need -= leftSize + 1;
                current = current.getRight();
            }
        }

        Node first = null;
        Node second = null;

        for (int i = path.size() - 1; i >= 0; i--) {
            Node node = path.get(i);
            if (wentRight.get(i)) {
                node.setRight(first);
                updateSize(node);
                first = node;
            } else {
                node.setLeft(second);
                updateSize(node);
                second = node;
            }
        }

        ArrayList<Node> result = new ArrayList<>(2);
        result.add(first);
        result.add(second);
        return result;
    }

    private static int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getSize();
    }

    private static void updateSize(Node node) {
        node.setSize(size(node.getLeft()) + size(node.getRight()) + 1);
    }

    // <template>
    private static class Node {
        private Node left;
        private Node right;
        private int value;
        private int size;

        Node(Node left, Node right, int value, int size) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.size = size;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
    // <template>

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }

    public static void test() {
        Node node1 = new Node(null, null, 3, 1);
        Node node2 = new Node(null, node1, 2, 2);
        Node node3 = new Node(null, null, 8, 1);
        Node node4 = new Node(null, null, 11, 1);
        Node node5 = new Node(node3, node4, 10, 3);
        Node node6 = new Node(node2, node5, 5, 6);

        List<Node> res = split(node6, 4);
        check(res.get(0) != null, "first tree is null");
        check(res.get(1) != null, "second tree is null");
        check(res.get(0).getSize() == 4, "first tree size must be 4");
        check(res.get(1).getSize() == 2, "second tree size must be 2");

        res = split(res.get(0), 0);
        check(res.get(0) == null, "first tree must be null when k = 0");
        check(res.get(1) != null, "second tree must not be null when k = 0");
        check(res.get(1).getSize() == 4, "second tree size must be 4");

        Node a = new Node(null, null, 1, 1);
        Node b = new Node(a, null, 2, 2);
        res = split(b, 2);
        check(res.get(0) != null, "first tree must not be null when k = n");
        check(res.get(0).getSize() == 2, "first tree size must be 2");
        check(res.get(1) == null, "second tree must be null when k = n");

        System.out.println("Test OK");
    }

    public static void main(String[] args) {
        test();
    }

}
