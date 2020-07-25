import java.util.ArrayList;

/**
 * Node to keep files.
 */
public class FileNode {
    private FileNode parent;
    protected ArrayList<FileNode> children;
    private String name;
    private boolean isDirectory;


    /**
     * @param name
     */
    public FileNode(String name) {
        this.name = name;
        this.parent = null;
        this.isDirectory=true;
        this.children = new ArrayList<FileNode>();
    }

    /**
     * @param name
     * @param parent
     * @param isDirectory
     */
    public FileNode(String name, FileNode parent,boolean isDirectory) {
        this.name = name;
        this.parent = parent;
        this.isDirectory=isDirectory;
        this.children = new ArrayList<FileNode>();
    }


    /**
     * Adds child to node.
     * @param child
     */
    public void addChild(FileNode child) {
        this.children.add(child);
    }


    /**
     * Returns the name of file.
     * @return
     */
    public String getData() {
        return this.name;
    }

    /**
     * Changes name of data
     * @param name
     */
    public void setData(String name) {
        this.name = name;
    }
}
