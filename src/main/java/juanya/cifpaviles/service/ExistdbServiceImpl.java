package juanya.cifpaviles.service;

import juanya.cifpaviles.repository.Db4oRepository;
import juanya.cifpaviles.repository.ExistdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ExistdbServiceImpl implements ExistdbService{
    private ExistdbRepository existdbRepository;
    @Autowired
    public ExistdbServiceImpl(ExistdbRepository existdbRepository) {
        this.existdbRepository = existdbRepository;
    }

    @Override
    public void createCollection(String colName) {
        existdbRepository.createCollection(colName);
    }

    @Override
    public void deleteCollection(String colName) {
        existdbRepository.deleteCollection(colName);
    }

    @Override
    public void createXMLResource(File file, String resourceName, String targetcol) {
        existdbRepository.createXMLResource(file, resourceName, targetcol);
    }

    @Override
    public void deleteXMLResource(String resourceName) {
        existdbRepository.deleteXMLResource(resourceName);
    }

    @Override
    public void printXMLfromCollection(String collectionName) {
        existdbRepository.printXMLfromCollection(collectionName);
    }
}
