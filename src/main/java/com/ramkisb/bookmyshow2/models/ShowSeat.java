package com.ramkisb.bookmyshow2.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    //in ShowSeat table, one row is one ShowSeat object
    //one row will have one show, one seat
    //but one show will be in many rows becaue one show could be 300 seats, the size of that Theater-Screen in seat count
    
     //ShowSeat : Show
    // 1 : 1
    //  M : 1
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date blockedAt;
}

// Show seat status
// 1  2 --
// 1 3 --
// 1 4 ---
// 2 2 ---