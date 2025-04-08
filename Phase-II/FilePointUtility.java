/**
 * The FilePointUtility class provides utility methods for the FilePoint class,
 * including methods to display file details and to check if a file has any
 * of the provided keywords.
 */
public class FilePointUtility {
    /**
     * Displays the details of a FilePoint object, including all attributes.
     *
     * @param filePoint The FilePoint object whose details will be displayed
     */
    public static void displayFileDetails(FilePoint filePoint) {
        System.out.println("File ID: " + filePoint.getFileID());
        System.out.println("File Name: " + filePoint.getFileName());
        System.out.println("File Size: " + filePoint.getFileSize() + " bytes");
        System.out.println("File Type: " + filePoint.getFileType());
        System.out.println("File Path: " + filePoint.getFilePath());
        System.out.println("Keywords: " + String.join(", ", filePoint.getKeywords()));
    }

    /**
     * Checks if a FilePoint object contains any of the specified keywords.
     * This method is useful for filtering files by multiple keywords.
     *
     * @param filePoint The FilePoint object to check
     * @param keywords  The keywords to search for
     * @return true if the file contains any of the keywords, false otherwise
     */
    public static boolean hasAnyKeyword(FilePoint filePoint, String... keywords) {
        // Stream through the keywords and check if any match those in the file's keyword list
        return java.util.Arrays.stream(keywords)
                .anyMatch(filePoint::hasKeyword);
    }
}
