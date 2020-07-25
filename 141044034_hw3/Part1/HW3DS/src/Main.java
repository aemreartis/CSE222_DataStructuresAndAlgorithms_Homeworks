import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {
        LinkedArrayList<Integer> obj = new LinkedArrayList<Integer>();
        ListIterator<Integer> myIter = obj.iterator();
        System.out.println("OBJECT METHOD TESTS:");

        System.out.println("IS EMPTY TEST:");
        if (obj.isEmpty())
            System.out.println("Empty");
        else
            System.out.println("Not empty");

        obj.add(0);
        System.out.println("Added: " + obj.get(0));

        if (obj.isEmpty())
            System.out.println("Empty");
        else
            System.out.println("Not empty");

        System.out.println("Add Tests");
        for (int i = 1; i < 30; i++) {
            obj.add(i);
            System.out.println("Add and get : " + obj.get(i));
        }
        obj.add(20, -1);

        System.out.println("Get 20 after add -1 to 20  : " + obj.get(20));

        System.out.println("Contains TEST:\nCheck if contains 25 as an element:");
        if (obj.contains(25))
            System.out.println("Contains");
        else
            System.out.println("Not contains");

        System.out.println("Remove TESTS:");
        System.out.println("Remove index 20");
        obj.remove(20);

        System.out.println("Remove element 20");
        obj.remove(new Integer(20));
        System.out.println("element '20' removed ");
        for (int i = 0; i < obj.size(); i++) {
            System.out.println("index["+i+"] = "+obj.get(i));
        }
        System.out.println("Size of linked array list: " + obj.size());

        System.out.println("LIST ITERATOR TESTS: \n Has next/previous TEST:");
        if(myIter.hasNext())
            System.out.println("Has next");
        else
            System.out.println("Hasn't next");

        if(myIter.hasPrevious())
            System.out.println("Has Previous");
        else
            System.out.println("Hasn't Previous");

        System.out.println("NEXT/PREVIOUS TEST:");

        while(myIter.hasNext())
            System.out.println(myIter.next());


        while(myIter.hasPrevious())
            System.out.println(myIter.previous());

        System.out.println("Previous/Next index method test");
        System.out.println("PreviousIndex:"+myIter.previousIndex() );
        System.out.println("NextIndex:"+myIter.nextIndex());

        System.out.println("Add/Remove/Set TEST:");
        myIter.add(new Integer(899));
        System.out.println("899 Added");
        System.out.println(myIter.previous());

        myIter.remove();
        System.out.println("899 Removed");
        System.out.println(myIter.previous());
        System.out.println(myIter.next());
        myIter.set(new Integer(900));
        while(myIter.hasNext())
            System.out.println(myIter.next());


        while(myIter.hasPrevious())
            System.out.println(myIter.previous());

    }
}
