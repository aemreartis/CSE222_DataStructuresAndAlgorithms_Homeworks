import javafx.beans.binding.ObjectExpression;

import java.util.Stack;

public class RecursiveFunctions {

    /**
     * @param sentence
     * @return Returns reversed string, works recursively.
     */
    public static String reverseString(String sentence) {
        int i = sentence.indexOf(' ');
        if (i == -1)
            return sentence;


        String current = sentence.substring(0, i);
        return reverseString(sentence.substring(i + 1)) + " " + current;
    }

    /**
     * Checks the given word if it has e , l , f letters with recursion.
     *
     * @param word
     * @param e
     * @param l
     * @param f
     * @return
     */
    public static boolean checkElfish(String word, boolean e, boolean l, boolean f) {

        if (word.length() == 0)
            return (e && l && f);

        if (word.charAt(0) == 'e')
            e = true;
        else if (word.charAt(0) == 'l')
            l = true;
        else if (word.charAt(0) == 'f')
            f = true;

        if (checkElfish(word.substring(1), e, l, f))
            return true;
        else
            return (e && l && f);
    }

    /**
     * Selection sor algorith implementation with recursion.
     *
     * @param array
     * @param index
     */
    public static void selectionSort(Object[] array, int index) {
        if (index == array.length)
            return;

        int k = minIndex(array, index);

        if (k != index) {
            Object temp = array[k];
            array[k] = array[index];
            array[index] = temp;
        }

        selectionSort(array, index + 1);
    }

    /**
     * Finds min val index
     *
     * @param array
     * @param index
     * @return
     */
    private static int minIndex(Object[] array, int index) {
        if (index == array.length - 1)
            return index;

        int k = minIndex(array, index + 1);

        if ((int) array[index] < (int) array[k])
            return index;
        else
            return k;
    }

    /**
     * Evaluates given prefix expression, returns evaluation
     *
     * @param expression
     * @param stack
     * @return
     */
    public static String evaluatePrefix(String expression, Stack<String> stack) {
        return Integer.toString(Integer.parseInt(String.valueOf(evaluatePostfix(reverseString(expression), stack))) *-1) ;
    }

    /**
     * Evaluates postfix expression, returns evaluation.
     *
     * @param expression
     * @param stack
     * @return
     */
    public static String evaluatePostfix(String expression, Stack<String> stack) {


        int i = expression.indexOf(' ');


        String current;
        if (i == -1)
            current = expression;
        else
            current = expression.substring(0, i);

        if (current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/")) {
            Integer first = Integer.parseInt(stack.pop());
            Integer second = Integer.parseInt(stack.pop());
            if (current.equals("+"))
                stack.push(String.valueOf(second+first ));
            else if (current.equals("/"))
                stack.push(String.valueOf(second/first));

            else if (current.equals("*"))
                stack.push(String.valueOf(second*first));
            else if (current.equals("-"))
                stack.push(String.valueOf(second-first));
        } else
            stack.push(current);

        if (i == -1) {

            return stack.pop();
        } else
            return evaluatePostfix(expression.substring(i + 1), stack);
    }

    /**
     * Prints given array as spiral order
     *
     * @param array
     * @param xs
     * @param xe
     * @param ys
     * @param ye
     */
    public static void printSpiral(Object[][] array, int xs, int xe, int ys, int ye) {
        if (xs == xe || ys == ye) {
            System.out.print(array[ys][xs]);
            return;
        }

        printLeftToRight(array, ys, xs, xe);

        printTopToBottom(array, xe, ys + 1, ye);

        printRightToLeft(array, ye, xe - 1, xs);

        printBottomToTop(array, xs, ye - 1, ys + 1);

        printSpiral(array, xs + 1, xe - 1, ys + 1, ye - 1);
    }

    /**
     * @param array
     * @param y
     * @param s
     * @param e
     */
    public static void printLeftToRight(Object[][] array, int y, int s, int e) {
        if (s == e)
            System.out.print(array[y][s] + " ");
        else {
            System.out.print(array[y][s] + " ");
            printLeftToRight(array, y, s + 1, e);
        }
    }

    /**
     * @param array
     * @param y
     * @param s
     * @param e
     */
    public static void printRightToLeft(Object[][] array, int y, int s, int e) {
        if (s == e)
            System.out.print(array[y][s] + " ");
        else {
            System.out.print(array[y][s] + " ");
            printRightToLeft(array, y, s - 1, e);
        }
    }

    /**
     * @param array
     * @param x
     * @param s
     * @param e
     */
    public static void printTopToBottom(Object[][] array, int x, int s, int e) {
        if (s == e)
            System.out.print(array[s][x] + " ");
        else {
            System.out.print(array[s][x] + " ");
            printTopToBottom(array, x, s + 1, e);
        }

    }

    /**
     * @param array
     * @param x
     * @param s
     * @param e
     */
    public static void printBottomToTop(Object[][] array, int x, int s, int e) {
        if (s == e)
            System.out.print(array[s][x] + " ");
        else {
            System.out.print(array[s][x] + " ");
            printBottomToTop(array, x, s - 1, e);
        }


    }
}
