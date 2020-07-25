import java.sql.SQLOutput;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Integer[] a=new Integer[5];
        Integer[][] b= new Integer[5][];

        a[0]=3;
        a[1]=2;
        a[2]=1;
        a[3]=4;
        a[4]=5;

        System.out.println("reverseString method test, input: bu gün okula gittim. Output:");
        System.out.println(RecursiveFunctions.reverseString("bu gün okula gittim"));

        System.out.println("CheckElfish method test, input: adasdasdef. Output:");
        System.out.println(RecursiveFunctions.checkElfish("adasdasdef",false,false,false));

        System.out.println("CheckElfish method test, input: adesdaldef. Output:");
        System.out.println(RecursiveFunctions.checkElfish("adesdaldef",false,false,false));

        System.out.println("Selection sort test İnput [3,2,1,4,5], Output:");
        RecursiveFunctions.selectionSort(a,0);


        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);

        System.out.println("Print Spiral test: input:");
        for (int i=0;i<5;i++)
            b[i]=new Integer[5];
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++){
                b[i][j] = (j+1)+i*5;
                System.out.print(b[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Output:");
        RecursiveFunctions.printSpiral(b,0,b[0].length-1,0,b.length-1);
        System.out.println();
        System.out.println("Postfix Test, given input: '4 3 2 * + 5 - ', expected '5' ");

        System.out.println("Result:"+(RecursiveFunctions.evaluatePostfix("4 3 2 * + 5 -",new Stack<>())));

        System.out.println("Prefix Test, given input: '- * + 4 3 2 5', expected '9' ");

        System.out.println("Result:"+(RecursiveFunctions.evaluatePrefix("- * + 4 3 2 5",new Stack<>())));
    }
}
