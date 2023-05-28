package com.project.Aprendex.controller;

import com.project.Aprendex.service.CursoService;
import com.project.Aprendex.service.UsuarioService;
import com.project.Aprendex.model.Curso;
import com.project.Aprendex.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("listaCurso", cursoService.topCurso());
        mv.addObject("curso", new Curso());
        return mv;
    }
    @GetMapping("/sair")
    public  String sair(HttpSession session){
        session.invalidate();
        return "redirect:";
    }


    @GetMapping("/sobre")
    public ModelAndView sobre () {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sobre");
        mv.addObject("usuario",new Usuario());
        return mv;
    }

    @GetMapping("/dadospessoais")
    public ModelAndView dados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("DadosPessoais");
        mv.addObject("usuario",new Usuario());
        return mv;
    }
    @GetMapping("/favoritos")
    public ModelAndView favoritos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("UsuarioFav");
        mv.addObject("usuario",new Usuario());
        mv.addObject("curso",new Curso());
        return mv;
    }

    @GetMapping("/cadastrar")
    public String cadastro() {

        return "cadastro";
    }

    @RequestMapping (value="/save",method=RequestMethod.POST)
    public String cadastrando(@ModelAttribute Usuario usuario) {

        this.usuarioService.cadastrar(usuario);

        return "redirect:";
    }

    @RequestMapping (value="/alterar",method=RequestMethod.POST)
    public String alterar(@ModelAttribute Usuario usuario) {

        this.usuarioService.alteraDados(usuario);

        return "redirect:";
    }
    @PostMapping (value="/logado")
    public ModelAndView logado(HttpSession session, Usuario usuario) {
        ModelAndView mv = new ModelAndView();

        Usuario userLogin = this.usuarioService.login(usuario.getEmail(), usuario.getSenha());
        usuario=userLogin;
        mv.addObject("usuario", usuario);
        if(usuario == null){
            mv.setViewName("/login");
        }else {
            session.setAttribute("usuarioLogado",  userLogin);
            return home();
        }

        return mv;
    }

    @RequestMapping (value="/curso-cadastrado",method=RequestMethod.POST)
    public ModelAndView cadastrocurso(Curso curso) {
        this.cursoService.cadastrarCurso(curso);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastroCurso");
        mv.addObject("usuario",new Usuario());
        return mv;
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/cursos")
    public ModelAndView cursos(String categoria){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("telacurso");
        mv.addObject("listaCategoria", cursoService.encontrarCategoria());
        mv.addObject("listaCurso", cursoService.cursodaCategoria(categoria));
        mv.addObject("usuario",new Usuario());
        mv.addObject("curso",new Curso());
        return mv;
    }

    @GetMapping("/cadastro-cursos")
    public ModelAndView cadastrocursos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastroCurso");
        mv.addObject("usuario",new Usuario());
        return mv;
    }

    @RequestMapping(value = "/buscar")
    public ModelAndView buscar(String buscar){
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaCurso", cursoService.encontrarCurso(buscar));
        mv.addObject("usuario",new Usuario());
        mv.addObject("curso",new Curso());
        mv.setViewName("busca");

        return mv;
    }

    @RequestMapping(value = "/favoritar")
    public ModelAndView favoritar(String cursoID, String usuarioID, HttpSession session){
        ModelAndView mv = new ModelAndView();
        session.setAttribute("usuarioLogado",this.usuarioService.favoritaCurso(usuarioID,cursoID));
        mv.addObject("listaCategoria", cursoService.encontrarCategoria());
        mv.setViewName("telacurso");
        return mv;
    }

    @RequestMapping(value = "/desfavoritar")
    public ModelAndView desfavoritar(String cursoID, String usuarioID, HttpSession session){
        ModelAndView mv = new ModelAndView();
        session.setAttribute("usuarioLogado",this.usuarioService.desfavoritaCurso(usuarioID,cursoID));
        mv.setViewName("UsuarioFav");
        return favoritos();
    }


}