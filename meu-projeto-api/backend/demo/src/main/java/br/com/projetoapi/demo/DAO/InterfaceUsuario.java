package br.com.projetoapi.demo.DAO;

import br.com.projetoapi.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuario extends CrudRepository<Usuario, Integer> {
}
