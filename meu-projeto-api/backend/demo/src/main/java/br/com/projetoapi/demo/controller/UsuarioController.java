package br.com.projetoapi.demo.controller;

import br.com.projetoapi.demo.DAO.InterfaceUsuario;
import br.com.projetoapi.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{
    @Autowired
    private InterfaceUsuario dao;
    @GetMapping
    public List<Usuario> usuarioList(){
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
            return novoUsuario;
        }

        @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAtualizado = dao.save(usuario);
        return usuarioAtualizado;
        }

        @DeleteMapping
    public Optional<Usuario> deletarUsuario(@PathVariable Integer id){
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
        }
    }


