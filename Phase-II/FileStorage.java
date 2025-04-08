/**
 * The FileStorage interface provides an abstract layer for file storage operations.
 * It defines basic file management methods, including sending, retrieving, and listing files.
 */
public interface FileStorage {
    /**
     * Stores a file in the storage system.
     *
     * @param filePath the local file path of the file to be stored.
     * @throws Exception if any I/O or database error occurs.
     */
    void sendFile(String filePath) throws Exception;

    /**
     * Retrieves a file from storage and saves it to a specified destination.
     *
     * @param fileName the name of the file to be retrieved from storage.
     * @param destinationPath the local path where the file will be saved.
     * @throws Exception if any I/O or database error occurs.
     */
    void retrieveFile(String fileName, String destinationPath) throws Exception;

    /**
     * Lists all file names currently stored in the storage system.
     *
     * @throws Exception if any database error occurs during the retrieval process.
     */
    void receiveFiles() throws Exception;
}
