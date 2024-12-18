package univer_lesson.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyTreeList treeList = new MyTreeList();

        System.out.println(treeList.size());

        treeList.insert(12);
        treeList.insert(15);
        treeList.insert(13);
        treeList.insert(10);
        treeList.insert(11);
        treeList.insert(14);

        System.out.println(treeList);

        System.out.println(treeList.deleteWithIterativeWay(13));

        System.out.println(treeList);
    }
}