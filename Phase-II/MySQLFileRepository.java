import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQLFileRepository is an implementation of the FileRepository interface for
 * MySQL databases. It handles file data storage, retrieval, and listing operations.
 */
public class MySQLFileRepository implements FileRepository {
    private final DatabaseConnection dbConnection;

    /**
     * Constructs a MySQLFileRepository with a specified DatabaseConnection instance.
     *
     * @param dbConnection an instance of DatabaseConnection for database access.
     */
    public MySQLFileRepository(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void saveFile(String fileName, Blob fileData) throws SQLException {
        String sql = "INSERT INTO files (filename, filedata) VALUES (?, ?)";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, fileName);
            statement.setBlob(2, fileData);
            statement.executeUpdate();
        }
    }

    @Override
    public Blob getFileData(String fileName) throws SQLException {
        String sql = "SELECT filedata FROM files WHERE filename = ?";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, fileName);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? resultSet.getBlob("filedata") : null;
        }
    }

    @Override
    public List<String> getFileNames() throws SQLException {
        String sql = "SELECT filename FROM files";
        List<String> fileNames = new ArrayList<>();
        
        try (Statement statement = dbConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                fileNames.add(resultSet.getString("filename"));
            }
        }
        return fileNames;
    }
}
