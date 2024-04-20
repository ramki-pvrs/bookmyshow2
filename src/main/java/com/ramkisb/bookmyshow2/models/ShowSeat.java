package com.ramkisb.bookmyshow2.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    // 1 : 1
    //  M : 1
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    //@Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date blockedAt;
}

// Show seat status
// 1  2 --
// 1 3 --
// 1 4 ---
// 2 2 ---