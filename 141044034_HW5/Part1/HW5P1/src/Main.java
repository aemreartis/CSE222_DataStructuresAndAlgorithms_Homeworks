public class Main {

    public static void main(String[] args) {
	// write your code
    FileSystemTree a =new FileSystemTree("root");

        System.out.println("Test printFileSystem addDir and addFile method ");

        System.out.println();
        System.out.println("Step 1 print empty FileSystem:");
        a.printFileSystem();

        System.out.println();
        System.out.println("Step 2 add file and directories");
        a.addDir("root/first_directory");
        a.addDir("root/second_directory");
        a.addFile("root/first_directory/new_file.txt");
        a.addDir("root/second_directory/new_directory");
        a.addFile("root/second_directory/new_directory/new_file.doc");

        System.out.println();
        System.out.println("Step 3 print FileSystem:");
        a.printFileSystem();

        System.out.println();
        System.out.println("Test search method: given parameter = 'new',expected result =1-new_file.txt 2-new_directory 3-new_file .doc");
        System.out.println("Result:");
        a.search("new");

        System.out.println();

        System.out.println("Test remove method step1: remove without asking.");
        a.remove("root/first_directory/new_file.txt");

        System.out.println();
        System.out.println("Test remove method step2:warn user about existance of path .");
        a.remove("root/first_directory/notexist");

        System.out.println();
        System.out.println("Test remove method step3: warn user before remove operation ");
        a.remove("root/second_directory/new_directory");

        System.out.println();
        System.out.println("Print File System after remove:");
        a.printFileSystem();
    }
}
