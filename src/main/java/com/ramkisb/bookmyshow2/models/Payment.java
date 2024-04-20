package com.ramkisb.bookmyshow2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Payment extends BaseModel{
    private int amount;
    private int refNo;
    
    //@Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    
    //@Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    
    //@Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    
    //one payment may be to multiple bookings; confirmed and cancelled
    //one booking can have only one payment
    //so payment to booking is many to one relation
    @ManyToOne
    private Booking booking;

}
