package udc.keynerinfante.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import udc.keynerinfante.modelo.Usuario;
import udc.keynerinfante.services.UsuarioService;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
        return "Usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "Usuario/editar";
    }

    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute("usuario") Usuario usuario, HttpSession session, Model model) {
        if (usuarioService.validarCredenciales(usuario.getClave(), usuario.getEmail())) {
            // Credenciales válidas, se inicia sesión
            session.setAttribute("loggedIn", true);
            model.addAttribute("loggedIn", true);
            model.addAttribute("usuarioLogueado", usuario.getNombre()); // Mostrar el nombre real del usuario
            return "index";
        } else {
            // Credenciales inválidas, se redirige al formulario de inicio de sesión con un mensaje de error
            return "redirect:/usuario/login?error";
        }
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio(Model model, HttpSession session) {
        if (session.getAttribute("loggedIn") != null) {
            model.addAttribute("loggedIn", true);
            // Aquí podrías obtener el nombre del usuario desde la sesión si lo necesitas
            // model.addAttribute("usuarioLogueado", nombreDeUsuario);
        }
        return "index";
    }


    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/usuario/login";
    }
}
