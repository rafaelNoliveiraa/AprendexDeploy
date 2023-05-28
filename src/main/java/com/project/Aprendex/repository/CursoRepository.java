package com.project.Aprendex.repository;

import com.project.Aprendex.model.Curso;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByNomeLikeIgnoreCase(String nome);

    Optional<Curso> findByDescricaoLikeIgnoreCase(String descricao);

    Optional<Curso> findByInstituicaoLikeIgnoreCase(String instituicao);

    Curso findCursoById(String id);

    Optional<Curso> findAllByCategoria(String categoria);

    List<Curso> getAllByCategoria();

    @Aggregation(pipeline = {
            "{$group: {_id: '$categoria'}}",
            "{$project: {_id: 0, categoria: '$_id'}}"
    })
    List<String> findDistinctCategories();

    List<Curso> findByCategoria(String categoria);



}
