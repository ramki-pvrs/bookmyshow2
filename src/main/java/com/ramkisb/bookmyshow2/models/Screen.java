package com.ramkisb.bookmyshow2.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Screen extends BaseModel{
    private String name;
    
    @OneToMany
    private List<Seat> seats;
    
    //@Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    
    
    //two cols 
    //Screen Theater
    //Many Screens : 1 Theater
    //M : 1
    //One Screen : One Theater
    //1 : 1
    //take max from each col, so M : 1
    
    @ManyToOne
    private Theater theater; 
    //is Theater required here; you will never reach theater through screen to book
}
