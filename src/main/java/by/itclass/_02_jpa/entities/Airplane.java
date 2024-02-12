package by.itclass._02_jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "airplane")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String model;
    @NonNull
    private int place;
    @OneToMany
    @JoinColumn(name = "airplane_id")
    List<Passenger> passengers;

    @Autowired
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
