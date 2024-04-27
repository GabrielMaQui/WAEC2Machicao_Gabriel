package pe.edu.cibertec.WAEC2Machicao_Gabriel.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Persona;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.service.IPersonaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/persona")
public class PersonaController {

    private IPersonaService iPersonaService;

    @GetMapping("/get")
    @ResponseBody
    public List<Persona> ListPersonas(){
        return iPersonaService.listaPersonas();
    }
}
