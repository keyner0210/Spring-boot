package udc.keynerinfante.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import udc.keynerinfante.modelo.Estudiante;
import udc.keynerinfante.services.EstudianteService;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "Estudiante/agregar";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.agregarEstudiante(estudiante);
        return "redirect:/estudiante/listar";
    }

    @GetMapping("/listar")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerTodosEstudiantes());
        return "estudiante/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "Estudiante/editar";
        }
        return "redirect:/estudiante/listar";
    }

    @PostMapping("/editar")
    public String editarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.editarEstudiante(estudiante);
        return "redirect:/estudiante/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiante/listar";
    }
}
