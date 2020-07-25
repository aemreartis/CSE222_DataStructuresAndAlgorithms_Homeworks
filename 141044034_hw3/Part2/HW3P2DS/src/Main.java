import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
    SimpleTextEditor arrayListDeneme = new SimpleTextEditor();
    SimpleTextEditor arrayListDeneme2 = new SimpleTextEditor();
    SimpleTextEditor linkedListDeneme = new SimpleTextEditor(new LinkedList());
    SimpleTextEditor linkedListDeneme2 = new SimpleTextEditor(new LinkedList());

    BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", false));
    long startTime,endTime;

    //READ TESTS

    //FİRST OBJECT
    System.out.println("ARRAYLIST:Read without iterator test:");
    startTime=System.nanoTime();
    arrayListDeneme.read("src/input.txt");
    endTime=System.nanoTime();

    AbstractList out=arrayListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Read without iterator executed, content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //SECOND OBJECT
    System.out.println("ARRAYLIST:Read with iterator test:");
    startTime=System.nanoTime();
    arrayListDeneme2.readIterator("src/input.txt");
    endTime=System.nanoTime();

    out=arrayListDeneme2.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Read with iterator executed, content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //THIRD OBJECT
    System.out.println("LINKEDLIST:Read without iterator test:");
    startTime=System.nanoTime();
    linkedListDeneme.read("src/input.txt");
    endTime=System.nanoTime();

    out=linkedListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("LinkedList Read without iterator executed, content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


    //FOURTH OBJECT
    System.out.println("LINKEDLIST:Read with iterator test:");
    startTime=System.nanoTime();
    linkedListDeneme2.readIterator("src/input.txt");
    endTime=System.nanoTime();

    out=linkedListDeneme2.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("LinkedList Read with iterator executed, content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //ADD TESTS

    //FIRST OBJECT
    System.out.println("ArrayList Add without iterartor test: add 'tekrar' ");

    startTime=System.nanoTime();
    arrayListDeneme.add("tekrar ",7);
    endTime=System.nanoTime();

    out=arrayListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Add without iterator executed, 'tekrar' word added at 7th index content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //SECOND OBJECT
    System.out.println("Add with iterartor test: add 'tekrar' ");

    startTime=System.nanoTime();
    arrayListDeneme2.addIterator("tekrar ",7);
    endTime=System.nanoTime();

    out=arrayListDeneme2.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Add with iterator executed, 'tekrar' word added at 7th index content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


    //THIRD OBJECT
    System.out.println("Linked List Add without iterartor test: add 'tekrar' ");

    startTime=System.nanoTime();
    linkedListDeneme.add("tekrar ",7);
    endTime=System.nanoTime();

    out=linkedListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("LinkedList Add without iterator executed, 'tekrar' word added at 7th index content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //FOURTH OBJECT
    System.out.println("LinkedList Add with iterartor test: add 'tekrar' ");

    startTime=System.nanoTime();
    linkedListDeneme2.addIterator("tekrar ",7);
    endTime=System.nanoTime();

    out=linkedListDeneme2.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("LinkedList Add with iterator executed, 'tekrar' word added at 7th index content is : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


    //FIND TESTS
    int index;

    //FIRST OBJECT

    System.out.println("ArrayList Find without iterator test: find 'okula' ");

    startTime=System.nanoTime();
    index = arrayListDeneme.find("okula");
    endTime=System.nanoTime();

    System.out.println("Start index : " + index);

    writer.newLine();
    writer.write("ArrayList Find without iterator executed, 'okula' word searched, Start Index : \n"+index+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

    //SECOND OBJECT

    System.out.println("ArrayList Find with iterator test: find 'okula' ");

    startTime=System.nanoTime();
    index = arrayListDeneme.findIterator("okula");
    endTime=System.nanoTime();

    System.out.println("Start index : " + index);

    writer.newLine();
    writer.write("ArrayList Find with iterator executed, 'okula' word searched, Start Index : \n"+index+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


        //THIRD OBJECT

        System.out.println("LinkedList Find without iterator test: find 'okula' ");

        startTime=System.nanoTime();
        index = linkedListDeneme.find("okula");
        endTime=System.nanoTime();

        System.out.println("Start index : " + index);

        writer.newLine();
        writer.write("LinkedList Find without iterator executed, 'okula' word searched, Start Index : \n"+index+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );

        //FOURTH OBJECT

        System.out.println("ArrayList Find with iterator test: find 'okula' ");

        startTime=System.nanoTime();
        index = linkedListDeneme2.findIterator("okula");
        endTime=System.nanoTime();

        System.out.println("Start index : " + index);

        writer.newLine();
        writer.write("LinkedList Find with iterator executed, 'okula' word searched, Start Index : \n"+index+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


    //REPLACE TESTS

    //FIRST OBJECT
    System.out.println("ArrayList Replace without iterator test: 'u' to 'e'");
    startTime=System.nanoTime();
    arrayListDeneme.replace("u".charAt(0),"e".charAt(0));
    endTime=System.nanoTime();
    out=arrayListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Replace without iterator executed, 'u' replaced to 'e' : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


    //SECOND OBJECT
    System.out.println("ArrayList Replace with iterator test: 'u' to 'e'");
    startTime=System.nanoTime();
    arrayListDeneme2.replace("u".charAt(0),"e".charAt(0));
    endTime=System.nanoTime();
    out=arrayListDeneme2.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("ArrayList Replace with iterator executed,  'u' replaced to 'e' : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );



    //THIRD OBJECT
    System.out.println("LinkedList Replace without iterator test: 'u' to 'e'");
    startTime=System.nanoTime();
    linkedListDeneme.replace("u".charAt(0),"e".charAt(0));
    endTime=System.nanoTime();
    out=linkedListDeneme.getText();
    System.out.println(out.toString());

    writer.newLine();
    writer.write("LinkedList Replace without iterator executed,  'u' replaced to 'e' : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );


        //FOURTH OBJECT
        System.out.println("LinkedList Replace with iterator test: 'u' to 'e'");
        startTime=System.nanoTime();
        linkedListDeneme2.replace("u".charAt(0),"e".charAt(0));
        endTime=System.nanoTime();
        out=linkedListDeneme2.getText();
        System.out.println(out.toString());

        writer.newLine();
        writer.write("LinkedList Replace with iterator executed,  'u' replaced to 'e' : \n"+out.toString()+"\n Running time:"+(endTime-startTime)+" nanoseconds\n" );




        writer.close();
    }
}
