package pe.edu.cibertec.WAEC2Machicao_Gabriel.service;

import pe.edu.cibertec.WAEC2Machicao_Gabriel.model.bd.Persona;
import pe.edu.cibertec.WAEC2Machicao_Gabriel.repository.PersonaRepository;

import java.util.List;

public class PersonaService implements IPersonaService{

    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listaPersonas() {
        return personaRepository.findAll();
    }
}
