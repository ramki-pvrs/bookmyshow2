package com.ramkisb.bookmyshow2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}

// Show SeatType price
// 1 Gold 300
// 1 Silver 600
// 2 Gold 500