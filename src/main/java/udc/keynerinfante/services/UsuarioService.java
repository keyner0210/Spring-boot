package udc.keynerinfante.services;


import org.springframework.stereotype.Service;

import udc.keynerinfante.modelo.Usuario;
import udc.keynerinfante.repositorio.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Long> obtenerTodosIds() {
        return usuarioRepository.obtenerTodosIds();
    }

    public boolean validarCredenciales(String clave, String email) {
        Usuario usuario = usuarioRepository.findByClaveAndEmail(clave, email);
        return usuario != null;
    }
}

