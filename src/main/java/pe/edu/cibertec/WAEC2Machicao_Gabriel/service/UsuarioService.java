package pe.edu.cibertec.WAEC2Machicao_Gabriel.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Rol;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.repository.RolRepository;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findUserByNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        usuario.setActivo(true);
        //Buscar el rol que le compete al usuario
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }
}
