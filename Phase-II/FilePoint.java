/**
 * The FilePoint class represents a file with its associated metadata,
 * including attributes like file ID, file name, size, type, path, and keywords.
 * This class provides getter and setter methods for each attribute and allows for
 * filtering files based on keywords.
 */
public class FilePoint {
    private final String fileID;
    private String fileName;
    private long fileSize;
    private String fileType;
    private String filePath;
    private String[] keywords;

     /**
     * Constructor to initialize essential attributes of the FilePoint.
     *
     * @param fileID   A unique ID for the file
     * @param fileName Name of the file
     * @param fileSize Size of the file in bytes
     * @param fileType Type of the file (e.g., "txt", "jpg")
     * @param filePath Path to the file's location on the filesystem
     */
    public FilePoint(String fileID, String fileName, long fileSize, String fileType, String filePath) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.filePath = filePath;
        this.keywords = new String[0]; // initialize empty keywords
    }

    // Getter methods for retrieving file attributes
    public String getFileID() { return fileID; }
    public String getFileName() { return fileName; }
    public long getFileSize() { return fileSize; }
    public String getFileType() { return fileType; }
    public String getFilePath() { return filePath; }
    public String[] getKeywords() { return keywords; }

    // Setter methods for updating file attributes
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setFileSize(long fileSize) { this.fileSize = fileSize; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setKeywords(String[] keywords) { this.keywords = keywords; }

    /**
     * Checks if the file contains a specific keyword.
     * This method is useful for filtering or searching files by keywords.
     *
     * @param keyword The keyword to search for
     * @return true if the keyword is present, false otherwise
     */
    public boolean hasKeyword(String keyword) {
        return java.util.Arrays.stream(keywords)
                .anyMatch(k -> k.equalsIgnoreCase(keyword));
    }
}
