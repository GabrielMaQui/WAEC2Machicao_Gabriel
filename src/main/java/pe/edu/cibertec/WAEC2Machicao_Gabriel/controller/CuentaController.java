package pe.edu.cibertec.WAEC2Machicao_Gabriel.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Cuenta;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Persona;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.dto.request.CuentaRequest;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.dto.response.ResultadoResponse;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.service.ICuentaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cuenta")
public class CuentaController {

    private ICuentaService icuentaService;

    @GetMapping("")
    public String formCuenta(Model model) {
        model.addAttribute("listcuenta", icuentaService.listarCuentas());
        return "backoffice/cuenta/formcuenta";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Cuenta> listarCuentas() {
        return icuentaService.listarCuentas();
    }


    @PostMapping("/cuenta/register")
    @ResponseBody
    public ResultadoResponse registroCuenta (@RequestBody CuentaRequest cuentaRequest){

        String mensaje = "Cuenta registrado correctamente";
        boolean respuesta = true;

        try{
            Cuenta cuenta = new Cuenta();
            if(cuentaRequest.getIdcuenta() > 0){
                cuenta.setIdcuenta(cuentaRequest.getIdcuenta());
            }
            cuenta.setNrocuenta(cuentaRequest.getNrocuenta());
            cuenta.setFecharegistro(cuentaRequest.getFecharegistro());
            cuenta.setFechavencimiento(cuentaRequest.getFechavencimiento());
            Persona persona = new Persona();
            persona.setIdpersona(cuentaRequest.getIdpersona());
            cuenta.setPersona(persona);

            icuentaService.registerCuenta(cuenta);

        } catch (Exception ex){
            mensaje = "Cuentao no registrado, error en la BD.";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }


}
