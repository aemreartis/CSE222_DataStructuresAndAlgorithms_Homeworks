public class Main {

    public static void main(String[] args) {

        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        System.out.println("Adding elements to tree: 10,20,5,15,10");
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));

        System.out.println("Printing tree with toString:");
        String treeStr = ageTree.toString();
        System.out.println(treeStr);

        System.out.println("Test youngerThan method: given parameter=15, expected result:3 ");
        System.out.println("Result: "+ageTree.youngerThan(15));

        System.out.println("Test olderThan method: given element=15, expected result:1 ");
        System.out.println("Result: "+ageTree.olderThan(15));

        System.out.println("Test find method: given element = 10,expected result=10-2");
        System.out.println("Result: " + ageTree.find(new AgeData(10)).toString());

        System.out.println("Test remove method step 1: given element=10, expected result=10-1");
        ageTree.remove(new AgeData(10));
        System.out.println("Result: " + ageTree.find(new AgeData(10)).toString());

        System.out.println("Test remove method step 2: given element=10, expected result=null");
        ageTree.remove(new AgeData(10));
        System.out.println("Result: " + ageTree.find(new AgeData(10)));

    }
}
