package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "PASSENGER_INFO")
public class PassengerInfo {
    @Id
    @GeneratedValue

    private Long id;

    private long pId;
    private String name;
    private String email;
    private String source;
    private String Destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date traveldate;
    private String pickupTime;
    private String arrivalTime;
    private Double fare;

}
