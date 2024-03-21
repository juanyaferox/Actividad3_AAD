package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tcarnet;

import java.util.List;

public interface MongoDbService {
    void BackupCarnets(List<Tcarnet> carnets);
}
