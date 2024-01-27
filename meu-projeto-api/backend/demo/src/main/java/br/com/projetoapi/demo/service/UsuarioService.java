package br.com.projetoapi.demo.service;

import br.com.projetoapi.demo.model.Usuario;
import br.com.projetoapi.demo.repository.InterfaceUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private InterfaceUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(InterfaceUsuario repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario alterarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioAltualizado = repository.save(usuario);
        return usuarioAltualizado;
    }

    public Boolean deletarUsuario(Integer id ){
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean validar = passwordEncoder.matches(usuario.getSenha(), senha);
        return validar;
    }
}
