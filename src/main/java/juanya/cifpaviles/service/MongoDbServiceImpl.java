package juanya.cifpaviles.service;

import juanya.cifpaviles.Metodos;
import juanya.cifpaviles.model.Tcarnet;
import juanya.cifpaviles.dto.TcarnetMongo;
import juanya.cifpaviles.repository.MongoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MongoDbServiceImpl implements MongoDbService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoDbRepository mongoDbRepository;
    public MongoDbServiceImpl(MongoDbRepository mongoDbRepository) {
        this.mongoDbRepository = mongoDbRepository;
    }


    @Override
    public void BackupCarnets(List<Tcarnet> carnets) {
        String collectionName = Metodos.generateBackupFileName();
        List<TcarnetMongo> tcarnetMongoList = carnets.stream()
                .map(this::convertToTcarnetMongo)
                .collect(Collectors.toList());
        for (TcarnetMongo tcarnetMongo : tcarnetMongoList) {
            mongoTemplate.save(tcarnetMongo, collectionName);
        }
    }
    private TcarnetMongo convertToTcarnetMongo(Tcarnet tcarnet) {
        TcarnetMongo tcarnetMongo = new TcarnetMongo();
        tcarnetMongo.setId(tcarnet.getId());
        tcarnetMongo.setFkidParada(tcarnet.getFkidParada().getId());
        tcarnetMongo.setFechaexp(tcarnet.getFechaexp());
        tcarnetMongo.setNvips(tcarnet.getNvips());
        tcarnetMongo.setDistancia(tcarnet.getDistancia());
        return tcarnetMongo;
    }
}
