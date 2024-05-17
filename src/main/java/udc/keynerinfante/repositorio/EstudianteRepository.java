package udc.keynerinfante.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import udc.keynerinfante.modelo.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query("SELECT DISTINCT e.usuarioId FROM Estudiante e")
    List<Integer> findDistinctUsuarioId();
}

