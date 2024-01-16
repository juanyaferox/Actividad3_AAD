package juanya.cifpaviles.service;

import juanya.cifpaviles.model.Tperegrino;
import juanya.cifpaviles.repository.TperegrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TperegrinoServiceImpl implements TperegrinoService{

    private final TperegrinoRepository tperegrinoRepository;

    @Autowired
    public TperegrinoServiceImpl(TperegrinoRepository tperegrinoRepository) {
        this.tperegrinoRepository = tperegrinoRepository;
    }

    @Override
    public List<Tperegrino> verificacion(String nombre, String nacionalidad) {
        return tperegrinoRepository.Verificacion(nombre, nacionalidad);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Tperegrino> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tperegrino> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Tperegrino> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Tperegrino getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Tperegrino getById(Integer integer) {
        return null;
    }

    @Override
    public Tperegrino getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Tperegrino> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tperegrino> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Tperegrino> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Tperegrino> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tperegrino> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tperegrino> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Tperegrino, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Tperegrino> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Tperegrino> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Tperegrino> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Tperegrino> findAll() {
        return null;
    }

    @Override
    public List<Tperegrino> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Tperegrino entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tperegrino> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tperegrino> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Tperegrino> findAll(Pageable pageable) {
        return null;
    }
}
