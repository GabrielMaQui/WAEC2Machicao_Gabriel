package pe.edu.cibertec.WAEC2Machicao_Gabriel.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET password=:password WHERE nomusuario=:nomusuario",
            nativeQuery = true)
    void actualizarUsuario(@Param("password") String password,
                           @Param("nomusuario") String nomusuario);
}


