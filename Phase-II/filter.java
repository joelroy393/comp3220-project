/*
 * Filter Class
 * Description: Given a set of files and keywords, this class should be able to sort based on category and/or keywords given.
 */

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private List<FilePoint> files;

    /**
     * Constructor for Filter class
     * Initializes Filter object with a list of files.
     * @param files a list of filePoint objects representing the files to filter
     */
    public Filter(List<FilePoint> files) {
        this.files = files;
    }

    /**
     * filterByKeyword method
     * Filters the file by keyword and returns data that matches the keyword.
     * @param keyword the keyword to filter files by
     * @return        a list that matches the keyword
     */
    public List<FilePoint> filterByKeyword(String keyword) {
        List<FilePoint> filteredFiles = new ArrayList<>();
        for (FilePoint file : files) {
            if (file.hasKeyword(keyword)) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }

    /**
     * filterByResourceType method
     * Filters the files based on resource type.
     * @param resourceType the resource type to filter files by (e.g. CSV, DWG, KMZ...)
     * @return             a list that matches the resource type
     */
    public List<FilePoint> filterByResourceType(String resourceType) {
        List<FilePoint> filteredFiles = new ArrayList<>();
        for (FilePoint file : files) {
            if (file.getFileType().equalsIgnoreCase(resourceType)) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }

    /**
     * filterByKeywordAndResourceType method
     * Outputs the filtered list by combining both keyword and resource type filters.
     * @param keyword      the keyword to filter files by
     * @param resourceType the resource type to filter files by
     * @return             a list that matches both the keyword and resource type
     */
    public List<FilePoint> filterByKeywordAndResourceType(String keyword, String resourceType) {
        List<FilePoint> filteredFiles = new ArrayList<>();
        for (FilePoint file : files) {
            if (file.hasKeyword(keyword) && file.getFileType().equalsIgnoreCase(resourceType)) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }

    /**
     * outputFilteredList method
     * Outputs the filtered lists along with file details.
     */
    public void outputFilteredList(List<FilePoint> filteredFiles) {
        for (FilePoint file : filteredFiles) {
            FilePointUtility.displayFileDetails(file);
        }
    }

}