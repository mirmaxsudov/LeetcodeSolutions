package univer_lesson.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyTreeList treeList = new MyTreeList();

        treeList.insert(12);
        treeList.insert(15);
        treeList.insert(13);
        treeList.insert(10);
        treeList.insert(11);
        treeList.insert(14);

        treeList.inOrderWithIterative();
//        treeList.inOrderPrint();
//        treeList.inOrderWithIterative();
    }
}