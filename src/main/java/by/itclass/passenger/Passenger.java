package by.itclass.passenger;

import by.itclass.airplane.Airplane;
import by.itclass.fligth.Flight;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String fio;
    @NonNull private String place;
    @ManyToOne
    @NonNull
    private Flight flight;

}
