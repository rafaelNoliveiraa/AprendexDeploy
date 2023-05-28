package com.project.Aprendex.service;

import com.project.Aprendex.model.Curso;
import com.project.Aprendex.repository.CursoRepository;
import com.project.Aprendex.repository.UsuarioRepository;
import com.project.Aprendex.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    private Usuario usuario =new Usuario();


    @Override
    public Usuario cadastrar( Usuario usuario) {
        if(encontrarEmail(usuario)) {
            if (validaEmail(usuario)){
                return this.usuarioRepository.save(usuario);
            }else {
                throw new IllegalStateException("Email Invalido");
            }
        }else {
            throw new IllegalStateException("Email já cadastrado");
        }
    }

    @Override
    public Usuario login(String email, String senha){
        Usuario usuario = usuarioRepository.findUsuarioByEmailAndSenha(email,senha);
        return usuario;
    }
    @Override
    public boolean encontrarEmail(Usuario usuario){
        Optional<Usuario> existEmail = this.usuarioRepository.findByEmail(usuario.getEmail());
        return existEmail.isEmpty();
    }

    @Override
    public boolean validaEmail(Usuario usuario){
        String email = usuario.getEmail();
        int validar = email.indexOf("@");

        System.out.println(validar);
        return validar > 0;
    }

    @Override
    public Usuario favoritaCurso(String idUsuario,String idCurso){
        Curso curso = this.cursoRepository.findCursoById(idCurso);
        List<Curso> cursos = new ArrayList<>();
        usuario = this.usuarioRepository.findUsuarioById(idUsuario);
        if(usuario.getCursoFavorito() != null) {
            cursos = usuario.getCursoFavorito();
            for(int i =0; i<cursos.size(); i++){
                if(cursos.get(i).getId().equals(idCurso)){
                    return usuario;
                }
            }
            cursos.add(curso);
            usuario.setCursoFavorito(cursos);
        }else{
            cursos.add(curso);
            usuario.setCursoFavorito(cursos);
        }
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public void alteraDados(Usuario Ausuario){

        usuario = this.usuarioRepository.findUsuarioById(Ausuario.getId());
        Ausuario.setCursoFavorito(usuario.getCursoFavorito());
        usuario = Ausuario;
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario desfavoritaCurso(String idUsuario, String idCurso){
        usuario = this.usuarioRepository.findUsuarioById(idUsuario);
        List<Curso> cursos = usuario.getCursoFavorito();
        for(int i = 0; i < cursos.size(); i++){
            if(cursos.get(i).getId().equals(idCurso)){
                cursos.remove(i);
            }
        }
        usuario.setCursoFavorito(cursos);
        return this.usuarioRepository.save(usuario);
    }
}