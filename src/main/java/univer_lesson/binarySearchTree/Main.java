package univer_lesson.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyTreeList treeList = new MyTreeList(5);

        System.out.println(treeList.size());

        treeList.insert(10);
        treeList.insert(11);
        treeList.insert(12);
        treeList.insert(13);

        System.out.println(treeList.size());

        System.out.println(treeList.getAll());
    }
}
