package com.project.Aprendex.service;

import com.project.Aprendex.model.*;
import com.project.Aprendex.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso cadastrarCurso(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> encontrarDesc(String desc) {
        Optional<Curso> curso = this.cursoRepository.findByDescricaoLikeIgnoreCase(desc);
        return curso;
    }

    @Override
    public Optional<Curso> encontrarNome(String nome) {
        Optional<Curso> curso = this.cursoRepository.findByDescricaoLikeIgnoreCase(nome);
        return curso;
    }

    @Override
    public void deletaCurso(String id) {

        this.cursoRepository.deleteById(id);
    }

    @Override
    public Curso encontrarId(String id) {
        Curso curso = this.cursoRepository.findCursoById(id);
        return curso;
    }

    @Override
    public List<Curso> topCurso(){
        List<Curso> curso = this.cursoRepository.findAll();
        return curso;
    }

    @Override
    public List<String> encontrarCategoria() {


        List<String>listacategoria=this.cursoRepository.findDistinctCategories();

        return listacategoria;
    }

    @Override
    public List<Curso> cursodaCategoria(String categoria) {
        List<Curso> cursos=this.cursoRepository.findByCategoria(categoria);
        return cursos;
    }

    @Override
    public List<Curso> encontrarCurso(String nome) {
        List<Curso> cursobuscado=this.cursoRepository.findByNomeLikeIgnoreCase(nome);

        return cursobuscado;
    }
}
