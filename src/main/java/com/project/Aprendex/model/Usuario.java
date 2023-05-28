package com.project.Aprendex.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Document(collection="Usuarios")
public class Usuario {


    @Id
    private String id;

    private String nome;
    private String sobrenome;
    private String login;
    private String senha;
    private String email;
    private Integer tipo;
    private Date dtnascimento;
    private List<Curso> cursoFavorito;
    public Usuario(String id, String nome, String sobrenome, String login, String senha, String email, Integer tipo, Date dtnascimento, List<Curso> cursoFavorito) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.dtnascimento = dtnascimento;
        this.cursoFavorito = cursoFavorito;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                ", dtnascimento=" + dtnascimento +
                ", cursoFavorito=" + cursoFavorito +
                '}';
    }
}
