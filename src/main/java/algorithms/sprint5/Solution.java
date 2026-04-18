// https://contest.yandex.ru/contest/24810/run-report/160624033/

// <template>
class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
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
}
// <template>

public class Solution {

    /*
     * Принцип работы алгоритма:
     * Используем свойство бинарного дерева поиска.
     * Если удаляемый ключ меньше значения в текущей вершине,
     * продолжаем поиск в левом поддереве.
     * Если больше — в правом.
     * Когда вершина с нужным ключом найдена, возможны три случая:
     *
     * 1) У вершины нет левого ребёнка.
     *    Тогда на её место должно встать правое поддерево.
     *
     * 2) У вершины нет правого ребёнка.
     *    Тогда на её место должно встать левое поддерево.
     *
     * 3) У вершины есть оба ребёнка.
     *    Тогда берём максимальный элемент из левого поддерева
     *    (это предшественник текущей вершины в порядке BST),
     *    записываем его значение в текущую вершину,
     *    а затем удаляем этот элемент из левого поддерева.
     *
     * Почему алгоритм корректен:
     * 1) По свойству BST искомый ключ может находиться только
     *    в одном из двух поддеревьев, поэтому рекурсивный спуск
     *    идёт ровно по нужному пути.
     *
     * 2) Если у удаляемой вершины не более одного ребёнка,
     *    замена вершины её единственным поддеревом
     *    сохраняет порядок ключей в дереве.
     *
     * 3) Если у вершины два ребёнка, максимум левого поддерева:
     *    - меньше значения любой вершины из правого поддерева;
     *    - не меньше всех остальных значений из левого поддерева.
     *    Поэтому после замены текущего ключа на этот максимум
     *    свойство BST сохраняется.
     *
     * 4) После этого мы удаляем из левого поддерева вершину,
     *    значение которой перенесли вверх. Так как ключи уникальны,
     *    удаляется ровно одна нужная вершина.
     *
     * Временная сложность: O(h), где h — высота дерева,
     * потому что мы спускаемся только по одному пути вниз.
     *
     * Пространственная сложность: O(h) из-за стека рекурсии.
     */

    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.getValue()) {
            root.setLeft(remove(root.getLeft(), key));
            return root;
        }

        if (key > root.getValue()) {
            root.setRight(remove(root.getRight(), key));
            return root;
        }

        if (root.getLeft() == null) {
            return root.getRight();
        }

        if (root.getRight() == null) {
            return root.getLeft();
        }

        Node predecessor = findMax(root.getLeft());
        root.setValue(predecessor.getValue());
        root.setLeft(remove(root.getLeft(), predecessor.getValue()));
        return root;
    }

    private static Node findMax(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);

        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;

        Node root = new Node(
                new Node(new Node(null, null, 2), new Node(null, null, 4), 3),
                new Node(new Node(null, null, 7), new Node(null, null, 9), 8),
                5
        );
        Node result = remove(root, 5);
        assert result.getValue() == 4;
        assert result.getLeft().getValue() == 3;
        assert result.getRight().getValue() == 8;

        Node single = new Node(null, null, 1);
        assert remove(single, 1) == null;

        Node unchanged = new Node(null, null, 1);
        assert remove(unchanged, 2) == unchanged;
    }
}