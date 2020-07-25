import java.util.*;

/**
 * Class to keep Library Data and methods
 */
public class Library {

    private Map<String, HashMap<String, HashSet<String>>> books;
    private Scanner inputReader;

    public Library() {
        books = new HashMap<String, HashMap<String, HashSet<String>>>();
        this.inputReader = new Scanner(System.in);
    }

    public Map<String, HashMap<String, HashSet<String>>> getBooks() {
        return books;
    }


    /**
     * Asks user name of the author and brings all books of the author, when user enters the book title,
     * it shows location(s) of the book.
     */
    public void searchByAuthor() {
        System.out.println("Name of the Author:");
        String authorName = inputReader.next();
        HashMap<String, HashSet<String>> tempMap=null;

        for (String key : books.keySet()) {
            if(key.compareTo(authorName)==0)
                tempMap= books.get(key);
        }
        for (String key : tempMap.keySet()) {
            System.out.println(key);
        }
        System.out.println("Which book do you searching for?");
        String bookTitle = inputReader.next();

        if(tempMap.containsKey(bookTitle))
            System.out.println(bookTitle+" location(s) :" + tempMap.get(bookTitle).toString());
        else
            System.out.println("Boook not exist.");
    }

    /**
     * Searches the book by Title and prints the author of the book and location(s) of it.
     */
    public void searchByTitle() {
        System.out.println("Which book do you want to find:");
        String bookTitle = inputReader.next();

        for (String key : books.keySet()) {
            HashMap<String, HashSet<String>> tempMap = books.get(key);

            if (tempMap.containsKey(bookTitle)) {
                System.out.println("Author name:"+key+", book found in location(s):");
                System.out.println(tempMap.get(bookTitle).toString());
            }
        }


    }


    /**
     * Adds new book to the library.
     */
    public void addBook() {
        System.out.println("Name of the Author:");
        String authorName = inputReader.next();

        System.out.println("Title of the Book:");
        String bookTitle = inputReader.next();

        System.out.println("Location of the Book:");
        String location = inputReader.next();

        HashSet<String> tempSet = new HashSet<String>();
        tempSet.add(location);

        HashMap<String, HashSet<String>> tempMap = new HashMap<String, HashSet<String>>();
        tempMap.put(bookTitle, tempSet);

        if(!books.containsKey(authorName))
            books.put(authorName, tempMap);
        else{
            if(!books.get(authorName).containsKey(bookTitle))
                books.get(authorName).putAll(tempMap);
            else
                books.get(authorName).get(bookTitle).add(location);
        }

    }

    /**
     * Removes the book by Title of the book.
     */
    public void removeBook() {
        System.out.println("Which book do you want to remove:");
        String bookName = inputReader.next();

        for (String key : books.keySet()) {
            HashMap<String, HashSet<String>> tempMap = books.get(key);

            if (tempMap.containsKey(bookName)) {
                tempMap.remove(bookName);
                books.put(key, tempMap);
            }
        }

    }

    /**
     * Gets the book name with its old location, and sets it to a new location.
     */
    public void updateBook() {
        System.out.println("Which book do you want to update:");
        String bookTitle = inputReader.next();
        String tempKey = null;
        for (String key : books.keySet()) {
            HashMap<String, HashSet<String>> tempMap = books.get(key);

            if (tempMap.containsKey(bookTitle)) {
                tempKey=key;
                System.out.println(bookTitle+" in location(s):");
                System.out.println(tempMap.get(bookTitle).toString());
            }
        }

        System.out.println("Old location:");
        String oldLoc = inputReader.next();

        System.out.println("New location:");
        String newLoc = inputReader.next();

        if(tempKey!=null) {
            books.get(tempKey).get(bookTitle).remove(oldLoc);
            books.get(tempKey).get(bookTitle).add(newLoc);
        }
        else
            System.out.println( "Book doesnt exist");

    }

    /**
     * Returns all books in the library
     * @return
     */
    @Override
    public String toString() {
        String tempString = null;
        for (String key : books.keySet()) {
            tempString+= "Author:"+key+"\n";
            HashMap<String, HashSet<String>> tempMap = books.get(key);
            tempString+= tempMap.toString()+"\n";
        }


        return tempString;
    }
}
