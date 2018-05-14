package paquete1.amv.repository;

import paquete1.amv.model.Usuario;
import java.util.List;                                                          //Manejo de listas
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;                      //Para realizar consultas en repositorios especificos en MongoDB
import org.springframework.stereotype.Repository;


@Repository("usuarioRepository")

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    List<Usuario> findFirstEmail(String email);
    Usuario findEmail(String email);
    boolean foundEmail (String email);
    
}