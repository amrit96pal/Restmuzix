package com.stackroute.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//This is for making as Entity
@Data//Implicitly adding getters and setters
@NoArgsConstructor//Implicitly adding no args constructor
@AllArgsConstructor//Implicitly adding all args constructor
@Builder
public class Track {

    @Id//making the trackid as the ID
    private int trackid;

    private String trackname;

    private String comments;

    @Override
    public String toString() {
        return "Track{" +
                "trackid=" + trackid +
                ", trackname='" + trackname + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
