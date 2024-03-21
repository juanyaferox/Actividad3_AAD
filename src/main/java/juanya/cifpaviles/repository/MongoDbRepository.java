package juanya.cifpaviles.repository;

import juanya.cifpaviles.dto.TcarnetMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MongoDbRepository extends MongoRepository<TcarnetMongo, Integer> {
}
