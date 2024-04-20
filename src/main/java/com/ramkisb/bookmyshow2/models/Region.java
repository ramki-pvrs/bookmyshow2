package com.ramkisb.bookmyshow2.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Region extends BaseModel{
    private String name;
    
    @OneToMany
    private List<Theater> theaters;
}
