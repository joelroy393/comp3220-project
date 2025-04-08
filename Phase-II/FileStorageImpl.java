import java.io.*;
import java.sql.Blob;
import java.util.List;

/**
 * FileStorageImpl is an implementation of the FileStorage interface, responsible for
 * interacting with a FileRepository to manage file storage operations such as sending,
 * retrieving, and listing files.
 */
public class FileStorageImpl implements FileStorage {
    private final FileRepository fileRepository;

    /**
     * Constructs a FileStorageImpl with a specified FileRepository instance.
     *
     * @param fileRepository an instance of FileRepository for file storage operations.
     */
    public FileStorageImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void sendFile(String filePath) throws Exception {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            // Creates a Blob from the file input stream
            Blob fileData = new javax.sql.rowset.serial.SerialBlob(fis.readAllBytes());
            fileRepository.saveFile(file.getName(), fileData);
        }
    }

    @Override
    public void retrieveFile(String fileName, String destinationPath) throws Exception {
        Blob fileData = fileRepository.getFileData(fileName);
        
        if (fileData != null) {
            // Writes the binary data to a file at the specified destination
            try (InputStream is = fileData.getBinaryStream();
                 FileOutputStream fos = new FileOutputStream(destinationPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                
                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        } else {
            System.out.println("File not found in the database.");
        }
    }

    @Override
    public void receiveFiles() throws Exception {
        // Retrieves and prints all file names from the repository
        List<String> fileNames = fileRepository.getFileNames();
        fileNames.forEach(System.out::println);
    }
}
