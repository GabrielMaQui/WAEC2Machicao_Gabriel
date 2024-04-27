package pe.edu.cibertec.WAEC2Machicao_Gabriel.service;

import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
}