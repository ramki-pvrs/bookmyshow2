package com.ramkisb.bookmyshow2.services;

import java.util.List;

import com.ramkisb.bookmyshow2.models.Booking;

public class BookingService {
    
    //observe that param bracket in new line
    //it takes three params
    
    //from booking service we will be returning Booking object
    
    public Booking bookTicket(
        List<Integer> showSeatIds,
        int showId,
        int userId
       ) {
            /*
             1. get User object from passed userId
             2. get Show object from passed showId
             //--- actual dB transaction may start here
             3. get all ShowSeat objects using showSeatIds (multiple)
             4. check all seats are available using ShowSeat object
             5. if no, throw error and return failure response
             6. if yes mark the seats as blocked immediately
              7. update ShowSeat in dB with latest blocked status
              -- close db transaction here
              8. create corresponding Booking object
              9. return booking obj
              
                 
             with all info about your booking request
             prepare Summary page
             
             */
            return new Booking();
        }
}
