package com.ramkisb.bookmyshow2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Seat extends BaseModel {
    private String number;
    private int seatrow;
    private int seatcol;
    
    @ManyToOne
    private SeatType seatType;
    //seat status will not be here but
    //in ShowSeat class because status is a function of Show & Seat
}
