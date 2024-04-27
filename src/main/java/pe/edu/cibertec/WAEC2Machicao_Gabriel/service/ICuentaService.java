package pe.edu.cibertec.WAEC2Machicao_Gabriel.service;

import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<Cuenta> listarCuentas();
    void registerCuenta(Cuenta cuenta);
}
