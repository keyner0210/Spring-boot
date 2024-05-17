package udc.keynerinfante.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import udc.keynerinfante.modelo.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para obtener todos los IDs de los usuarios
    @Query("SELECT DISTINCT u.id FROM Usuario u")
    List<Long> obtenerTodosIds();  // Cambiado a Long si el ID es numérico

    // Método para buscar un usuario por clave y email
    @Query("Select u from Usuario u where u.clave = :clave  and u.email = :email")
    Usuario findByClaveAndEmail(String clave, String email);
    
}

