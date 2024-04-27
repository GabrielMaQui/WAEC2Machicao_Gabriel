package pe.edu.cibertec.WAEC2Machicao_Gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}