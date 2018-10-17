package com.example.demo.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Personnes;

public class PersonneCreationDto {
	
	private List<Personnes> personnes;

    public PersonneCreationDto() {
        this.personnes = new ArrayList<>();
    }

    public PersonneCreationDto(List<Personnes> personnes) {
        this.personnes = personnes;
    }

    public List<Personnes> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personnes> personnes) {
        this.personnes = personnes;
    }

    public void addPersonne(Personnes personnes) {
        this.personnes.add(personnes);
    }
}
