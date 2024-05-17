package udc.keynerinfante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import udc.keynerinfante.modelo.Estudiante;
import udc.keynerinfante.repositorio.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(int id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public void editarEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(int id) {
        estudianteRepository.deleteById(id);
    }

    public List<Integer> obtenerUsuarioIds() {
        return estudianteRepository.findDistinctUsuarioId();
    }
}

