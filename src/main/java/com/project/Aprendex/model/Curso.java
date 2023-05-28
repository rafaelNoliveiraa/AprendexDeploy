package com.project.Aprendex.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document()
public class Curso{

    @Id
    private String id;
    private String nome;
    private String descricao;
    private String link;
    private String endereco;
    private String instituicao;
    private String categoria;
    private int duracao;
    private String telefone;
    private String email;
    private Double valor;
    private String img;

    public Curso(String id, String nome, String descricao, String link, String endereco, String instituicao,String categoria,String telefone, String email, int duracao, Double valor, String img) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
        this.endereco = endereco;
        this.instituicao = instituicao;
        this.categoria  = categoria;
        this.telefone =telefone;
        this.email = email;
        this.duracao = duracao;
        this.valor = valor;
        this.img = img;
    }

    public Curso(){}
    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", link='" + link + '\'' +
                ", endereco='" + endereco + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", imagem=" + img +
                '}';
    }
}
