package com.project.Aprendex.repository;

import com.project.Aprendex.model.*;
import com.project.Aprendex.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario, String> {

    Optional<Usuario> findByEmail(String email);

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findUsuarioByEmailAndSenha(String email,String senha);

    Usuario findUsuarioById(String id);


}
