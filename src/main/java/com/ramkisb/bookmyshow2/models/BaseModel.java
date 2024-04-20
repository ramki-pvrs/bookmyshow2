//for lombok to work after dependencies are done in sprint.io
//got0 C:\Users\Ramkrishnan S\.m2\repository\org\projectlombok\lombok\1.18.30>
//java -jar .\lombok-1.18.30.jar
//restart eclipse and
//right click on your projecct name scaler_bms and Run As maven clean


//to let Hibernate know that this int id is used 
//in all child classes as primary key
//MappedSuperClass means, all these attributes should be separately added as columns in each sql table
//



package com.ramkisb.bookmyshow2.models;

import java.util.Date;

//import org.springframework.data.annotation.Id; //Ramki: not working line
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    
    //primary key for subclass like Booking
    //requires @Id annotation
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
