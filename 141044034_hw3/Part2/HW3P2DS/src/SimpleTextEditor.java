import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Simple text editor class to keep data and methods
 */
public class SimpleTextEditor {

    AbstractList text;

    SimpleTextEditor() {
        text = new ArrayList();
    }

    SimpleTextEditor(AbstractList inList) {
        text = inList;
    }

    public AbstractList getText() {
        return text;
    }

    /**
     * Reads file in to list
     *
     * @param filename
     * @throws IOException
     */
    public void read(String filename) throws IOException {
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        int c = 0;

        while ((c = br.read()) != -1) {

            Character character = (char) c;          //converting integer to char
            text.add(character);
        }
    }

    void clear(){
        text.clear();
    }
    /**
     * Adds elements given position
     *
     * @param elements
     * @param index
     */
    public void add(String elements, int index) {
        for (int i = 0; i < elements.length(); i++)
            text.add(index + i, elements.charAt(i));
    }

    /**
     * Finds given strings start index, if cant returns -1
     *
     * @param element
     * @return
     */
    public int find(String element) {
        boolean found = false;

        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).equals(element.charAt(0)))
                if (element.length() == 1)
                    return i;
                else
                    for (int j = 1; j < element.length(); j++) {
                        if (!text.get(i + j).equals(element.charAt(j)))
                            break;
                        if (j == element.length() - 1)
                            found = true;
                    }
            if (found)
                return i;
        }
        return -1;
    }

    /**
     * Replaces old element with new element
     *
     * @param oldElement
     * @param newElement
     */
    public void replace(Character oldElement, Character newElement) {
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).equals(oldElement))
                text.set(i, newElement);
        }
    }


    public void readIterator(String filename) throws IOException {
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        ListIterator iterator = (ListIterator) text.listIterator();

        int c = 0;

        while ((c = br.read()) != -1) {

            Character character = (char) c;          //converting integer to char
            iterator.add(character);
        }
    }


    /**
     * Adds elements given position
     *
     * @param elements
     * @param index
     */
    public void addIterator(String elements, int index) {

        ListIterator iterator = (ListIterator) text.listIterator();

        while (iterator.nextIndex() != index)
            iterator.next();

        for (int i = 0; i < elements.length(); i++) {
            iterator.add(elements.charAt(i));
        }
    }

    /**
     * Finds given strings start index, if cant returns -1
     *
     * @param element
     * @return
     */
    public int findIterator(String element) {
        boolean found = false;
        ListIterator iterator = (ListIterator) text.listIterator();
        ListIterator temp;

        for (int i = 0; iterator.hasNext(); i++) {
            if (iterator.next().equals(element.charAt(0))) {
                temp = iterator;
                if (element.length() == 1)
                    return i;
                else
                    for (int j = 1; j < element.length(); j++) {
                        if (!iterator.next().equals(element.charAt(j)))
                            break;
                        if (j == element.length() - 1)
                            found = true;
                    }
                iterator = temp;
            }
            if (found)
                return i;
        }
        return -1;
    }

    /**
     * Replaces old element with new element
     *
     * @param oldElement
     * @param newElement
     */
    public void replaceIterator(Character oldElement, Character newElement) {

        ListIterator iterator =  text.listIterator();

        while(iterator.hasNext()) {
            if (iterator.next().equals(oldElement))
                iterator.set(newElement);
        }
    }

}
