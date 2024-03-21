package juanya.cifpaviles.service;

import java.io.File;

public interface ExistdbService {
    void createCollection(String colName);
    void deleteCollection(String colName);

    void createXMLResource(File file, String resourceName, String targetcol);

    void deleteXMLResource(String resourceName);
    void printXMLfromCollection(String collectionName);
}
