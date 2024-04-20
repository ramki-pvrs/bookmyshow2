package com.ramkisb.bookmyshow2.models;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//to create sql table using Hibernate + Spring JPA
//requires primary key

@Entity
public class Booking extends BaseModel{
    //Cardinality between Booking and User
    //1 booking : 1 user
    //1 user : M booking 
    //otherway M booking : 1 user
    //so cardinality between Booking and User is M : 1, direction matters
    
    @ManyToOne
    private User user;
    
    private BookingStatus bookingStatus;
    private Date bookingAt;
    
    //Booking to Show 1 : 1 //One Booking object belongs to one show only
    //Show to Booking 1 : M //one show in one theater one screen may have multiple bookings
    //Otherway M : 1 Booking : Show, take the larger 
    
    @ManyToOne 
    private Show show;
    
    
    
    //Booking : ShowSeat is 1 : M
    //ShowSeat : Booking is M : 1 //many because if one cancells, status will be Cancelled but Confirmed booking also will show the same seat
    //so M Booking : M ShowSeat 
    @ManyToMany
    private List<ShowSeat> showSeats;
    private int amount; //total amount of this booking
    
    //confirmed payment; cancelled payment
    @OneToMany
    private List<Payment> payments; //booked payment, cancelled return payment
    
}
