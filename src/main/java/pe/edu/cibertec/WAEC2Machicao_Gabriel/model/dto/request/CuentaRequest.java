package pe.edu.cibertec.WAEC2Machicao_Gabriel.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CuentaRequest {
    private Integer idcuenta;
    private String nrocuenta;
    private Date fecharegistro;
    private Date fechavencimiento;
    private Integer idpersona;
}
