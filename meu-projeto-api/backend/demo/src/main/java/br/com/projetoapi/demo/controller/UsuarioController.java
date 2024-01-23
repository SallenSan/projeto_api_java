package br.com.projetoapi.demo.controller;

import br.com.projetoapi.demo.DAO.InterfaceUsuario;
import br.com.projetoapi.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Usuario>> usuarioList(){
        List <Usuario> usuarioList = (List<Usuario>) dao.findAll();
        return ResponseEntity.status(200).body(usuarioList);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
            return ResponseEntity.status(201).body(novoUsuario);
        }

        @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAtualizado = dao.save(usuario);
        return ResponseEntity.status(201).body(usuarioAtualizado);
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
        }
    }


