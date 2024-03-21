package juanya.cifpaviles.repository;

import org.xmldb.api.base.Collection;

import java.io.File;

public interface ExistdbRepository {
    void createCollection(String colName);
    void deleteCollection(String colName);

    void createXMLResource(File file, String resourceName, String targetcol);

    void deleteXMLResource(String resourceName);
    void printXMLfromCollection(String collectionName);
}
