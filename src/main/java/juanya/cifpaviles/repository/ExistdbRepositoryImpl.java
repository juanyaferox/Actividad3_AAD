package juanya.cifpaviles.repository;

import juanya.cifpaviles.conexionesDB.existdbConnection;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Repository
public class ExistdbRepositoryImpl implements ExistdbRepository {

    Collection col;
    XMLResource res;
    public ExistdbRepositoryImpl() {
        existdbConnection existdbConnection = new existdbConnection();
        this.col = existdbConnection.getCollection();
        this.res = existdbConnection.getXMLResource();
        System.out.println("Conexión a existdb realizada con éxito");
    }

    @Override
    public void createCollection(String colName) {
        try {
            CollectionManagementService mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
            mgtService.createCollection(colName);
        } catch (XMLDBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCollection(String colName) {
        CollectionManagementService mgtService = null;
        try {
            mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
            mgtService.removeCollection(colName);
        } catch (XMLDBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createXMLResource(File file, String resourceName, String targetcol) {
        try{
            col = col.getChildCollection(targetcol);
            res = (XMLResource) col.createResource(file.getName(), "XMLResource");
            res.setContent(file);
            System.out.print("storing document " + res.getId() + "...");
            col.storeResource(res);
            System.out.println("done.");
            col = col.getParentCollection();//volvemos al directorio anterior
        } catch (XMLDBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteXMLResource(String resourceName) {
        try{
            Resource recursoParaBorrar = col.getResource(resourceName);
            col.removeResource(recursoParaBorrar);
            System.out.println(recursoParaBorrar.getId() + " borrado.");
        }catch (XMLDBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printXMLfromCollection(String collectionName) {
        try {
            col = col.getChildCollection(collectionName);
            String resources[] = col.listResources();
            System.out.println("Resources:");
            for (String resourceName : resources) {
                Resource res = col.getResource(resourceName);
                if (res instanceof XMLResource) {
                    XMLResource resource = (XMLResource) res;
                    System.out.println("Resource: " + resourceName);
                    System.out.println(resource.getContent());
                }
            }
        } catch (XMLDBException e) {
            e.printStackTrace();
        } finally {
            try{
                col = col.getParentCollection();
            } catch (XMLDBException e) {
                e.printStackTrace();
            }
        }
    }
}
