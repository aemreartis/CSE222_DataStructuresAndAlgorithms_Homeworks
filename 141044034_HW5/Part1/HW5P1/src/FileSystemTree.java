import java.util.Scanner;

/**
 * FileSystemTree class to keep file system.
 */
public class FileSystemTree {
    FileNode root;

    /**
     * @param rootName
     */
    FileSystemTree(String rootName) {
        root = new FileNode(rootName);
    }

    /**
     * Adds directory to file system.
     * @param directoryName
     */
    public void addDir(String directoryName) {
        String[] temp = directoryName.split("/");
        FileNode tempNode = root;
        int foundIndex = 0;
        boolean found = false;

        if (!temp[0].equals(root.getData())) {
            System.out.println("Mismatch with root node");
            return;
        }

        for (int i = 1; i < temp.length; i++) {

            for (int j = 0; j < tempNode.children.size(); j++) {

                if (tempNode.children.get(j).getData().equals(temp[i])) {
                    found = true;
                    foundIndex = j;
                }
            }

            if (found)
                tempNode = tempNode.children.get(foundIndex);
            else {
                tempNode.addChild(new FileNode(temp[i], tempNode, true));
                tempNode = tempNode.children.get(0);
            }
            found = false;
        }


    }

    /**
     * Adds file to file system
     * @param fileName
     */
    public void addFile(String fileName) {
        String[] temp = fileName.split("/");
        FileNode tempNode = root;
        int foundIndex = 0;
        boolean found = false;

        if (!temp[0].equals(root.getData())) {
            System.out.println("Mismatch with root node");
            return;
        }

        for (int i = 1; i < temp.length; i++) {
            for (int j = 0; j < tempNode.children.size(); j++) {
                if (tempNode.children.get(j).getData().equals(temp[i])) {
                    found = true;
                    foundIndex = j;
                }
            }
            if (found)
                tempNode = tempNode.children.get(foundIndex);
            else {
                if (i == temp.length - 1)
                    tempNode.addChild(new FileNode(temp[i], tempNode, false));
                else
                    tempNode.addChild(new FileNode(temp[i], tempNode, true));
                tempNode = tempNode.children.get(0);
            }
            found = false;
        }


    }

    /**
     * Removes the given element from file system.
     * @param fileName
     * @return
     */
    public FileNode remove(String fileName) {
        String[] temp = fileName.split("/");
        FileNode tempNode = root;
        int foundIndex = 0;
        boolean found = false;

        if (!temp[0].equals(root.getData())) {
            System.out.println("Mismatch with root node");
            return null;
        }

        for (int i = 1; i < temp.length; i++) {
            for (int j = 0; j < tempNode.children.size(); j++) {
                if (tempNode.children.get(j).getData().equals(temp[i])) {
                    found = true;
                    foundIndex = j;

                }
            }

            if (found) {

                if (temp.length - 1 == i) {
                    boolean delete = true;
                    Scanner reader = new Scanner(System.in);
                    if (tempNode.children.get(foundIndex).children.size() > 0) {
                        String ans;
                        System.out.println("Selected file may contain some other  directories or files, Do you still want to delete? (y/n)");
                        ans = reader.nextLine();

                        if (ans.equals("y"))
                            delete = true;
                        else
                            delete = false;
                    }

                    if (delete)
                        tempNode.children.remove(foundIndex);
                } else
                    tempNode = tempNode.children.get(foundIndex);
            } else {
                System.out.println("Path cannot be found");
                return null;
            }
            found = false;
        }


        return null;
    }

    /**
     * Searches in the file system
     * @param word
     */
    public void search(String word) {
        recursiveSearch(root,word,root.getData());
    }

    /**
     * Searches recursively
     * @param root
     * @param word
     * @param path
     */
    private void recursiveSearch(FileNode root, String word,String path) {

        for (int i = 0; i < root.children.size(); i++)
            recursiveSearch(root.children.get(i),word, path+"/"+root.children.get(i).getData());

        if(root.getData().indexOf(word) != -1)
            System.out.println(path+"/"+root.getData());
    }


    /**
     * Prints all file system.
     */
    public void printFileSystem() {
        recursivePrint(root,root.getData());
    }

    /**
     * Prints file system recursively
     * @param root
     * @param path
     */
    private void recursivePrint(FileNode root,String path) {
        System.out.println(path);
        for (int i = 0; i < root.children.size(); i++)
            recursivePrint(root.children.get(i), path+"/"+root.children.get(i).getData());
    }

}
