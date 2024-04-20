package com.ramkisb.bookmyshow2.models;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Movie extends BaseModel {
    private String title;
    private List<String> actors;
    private String director;
    
}