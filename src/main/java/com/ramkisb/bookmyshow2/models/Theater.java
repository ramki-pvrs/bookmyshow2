package com.ramkisb.bookmyshow2.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;
//    private List<Screen> screens;
    @OneToMany
    private List<Show> shows;
}