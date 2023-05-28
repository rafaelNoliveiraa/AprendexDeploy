package com.project.Aprendex.service;

import com.project.Aprendex.model.Curso;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public interface CursoService {
    public Curso cadastrarCurso(Curso curso);

    public Optional<Curso> encontrarDesc(String desc);

    public Optional<Curso> encontrarNome(String nome);

    public Curso encontrarId(String id);

    public void deletaCurso(String id);

    public List<Curso> topCurso();

    public List<String> encontrarCategoria();

    public List<Curso> cursodaCategoria(String categoria);

    public List<Curso> encontrarCurso(String nome);
}
