package pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcuenta;
    private String nrocuenta;
    private Date fecharegistro;
    private Date fechavencimiento;
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private Persona persona;

}
