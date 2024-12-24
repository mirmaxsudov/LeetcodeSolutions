package univer_lesson.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyTreeList treeList = new MyTreeList();

        treeList.insert(4);
        treeList.insert(2);
        treeList.insert(6);
        treeList.insert(1);
        treeList.insert(3);
        treeList.insert(5);
        treeList.insert(7);

        System.out.println("InOrder");
        treeList.inOrderPrint();
        treeList.inOrderWithIterative();
        System.out.println("\nPreOrder");
        treeList.preOrderPrint();
        System.out.println("\nLevelOrder");
        treeList.levelOrderWithIterative();
    }
}