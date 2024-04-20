package com.ramkisb.bookmyshow2.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

//because Seat Type can be different for Regions and each Theater in them
//it is not some fixed list of values; so enum is not suitable type
//an object model

@Getter
@Setter

@Entity

//remember id as primary key comes from BaseModel
public class SeatType extends BaseModel{
    private String seatType;
    
}
