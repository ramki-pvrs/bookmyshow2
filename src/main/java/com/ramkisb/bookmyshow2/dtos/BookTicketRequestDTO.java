package com.ramkisb.bookmyshow2.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


//Book Ticket meaning, user clicking on it
//that means user has already selected the movie, show and seats
//those selected values are private attributes here passed to dto
//to be consumed in controller

@Getter
@Setter


public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int showId;
    private int userId;
    
}
