package br.com.projetoapi.demo.service;

import br.com.projetoapi.demo.model.Usuario;
import br.com.projetoapi.demo.repository.InterfaceUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private InterfaceUsuario repository;

    public UsuarioService(InterfaceUsuario repository){
        this.repository = repository;
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario alterarUsuario(Usuario usuario){
        Usuario usuarioAltualizado = repository.save(usuario);
        return usuarioAltualizado;
    }

    public Boolean deletarUsuario(Integer id ){
        repository.deleteById(id);
        return true;
    }
}
