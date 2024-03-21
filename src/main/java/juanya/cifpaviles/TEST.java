package juanya.cifpaviles;

import juanya.cifpaviles.repository.ExistdbRepositoryImpl;
import juanya.cifpaviles.service.ExistdbServiceImpl;

public class TEST {
    public static void main(String[] args) {
        ExistdbRepositoryImpl existdbRepository = new ExistdbRepositoryImpl();
        existdbRepository.createCollection("test");
    }
}
