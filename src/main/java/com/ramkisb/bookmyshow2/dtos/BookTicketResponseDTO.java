package com.ramkisb.bookmyshow2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookTicketResponseDTO {
    public BookTicketResponseStatus bookTicketResponseStatus;
    
    //when the booking is done, you will be sending the booking id
    private Long bookingId;
    
    //booking ticket will not complete it but take you
    //to summary page and payment
    
    
    //Note: based on seat types and number of seats and per seat price
    //bookingamount can be calculated at GUI itself and send to backend
    //or may be calculated backend
    private int bookingamount;
    
    
    
}
