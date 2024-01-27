package br.com.projetoapi.demo.repository;

import br.com.projetoapi.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceUsuario extends JpaRepository<Usuario, Integer> {
}
