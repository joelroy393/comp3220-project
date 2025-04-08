import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * The FileRepository interface abstracts the data access operations for file storage.
 * It defines methods to save, retrieve, and list file data stored in a database.
 */
public interface FileRepository {
    /**
     * Saves a file to the database.
     *
     * @param fileName the name of the file to be saved.
     * @param fileData the binary data of the file as a Blob object.
     * @throws SQLException if any SQL error occurs during the save operation.
     */
    void saveFile(String fileName, Blob fileData) throws SQLException;

    /**
     * Retrieves the binary data of a specified file from the database.
     *
     * @param fileName the name of the file to be retrieved.
     * @return a Blob object containing the file's binary data, or null if the file is not found.
     * @throws SQLException if any SQL error occurs during the retrieval process.
     */
    Blob getFileData(String fileName) throws SQLException;

    /**
     * Retrieves a list of all file names stored in the database.
     *
     * @return a List of file names currently stored.
     * @throws SQLException if any SQL error occurs during the retrieval process.
     */
    List<String> getFileNames() throws SQLException;
}
