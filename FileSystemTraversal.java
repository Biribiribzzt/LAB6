import java.io.File;

public class FileSystemTraversal {
    

    /**
     * Calculates the total disk usage (in bytes) of the portion of the file system
     * rooted at the given path.
     *
     * @param root The file or directory to be measured.
     * @return The total number of bytes.
     */
    public static long diskUsage(File root) {
        // Start with the size of the file/directory itself.
        // For a file, this is its length. For a directory, it's a small amount of metadata.
        long total = root.length();

        // Check if the 'root' is a directory.
        if (root.isDirectory()) {
            // If it's a directory, we need to traverse its contents.
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Recursively calculate the disk usage for each file/directory inside.
                    total += diskUsage(file);
                }
            } else {
                System.err.println("Could not list files in directory: " + root.getAbsolutePath());
            }
        } else if (!root.exists()) {
            System.err.println("File does not exist: " + root.getAbsolutePath());
            return 0; // If the file doesn't exist, return 0.
        }
        System.out.println(total + "\t" + root.getName());
        return total;
    }

    /**
     * Main method for testing.
     * Note: You will need to change the path to a directory that exists on your computer.
     */
    public static void main(String[] args) {
        // IMPORTANT: Replace this path with a real directory path on your machine.
        // For example: "C:/Users/YourUser/Documents" on Windows
        // or "/home/youruser/documents" on Linux/macOS.
        File myDirectory = new File("./"); // Using current directory as an example.

        System.out.println("Calculating disk usage for: " + myDirectory.getAbsolutePath());
        long totalSize = diskUsage(myDirectory);
        System.out.println("------------------------------------");
        System.out.println("Total Disk Usage: " + totalSize + " bytes.");
    }
}

