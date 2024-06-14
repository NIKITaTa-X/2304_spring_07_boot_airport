package by.itclass.fligth;

import by.itclass.airplane.Airplane;
import by.itclass.passenger.Passenger;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String number;
    @NonNull private String direction;
    @ManyToOne
    @NonNull private Airplane airplane;
    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
    private List<Passenger> passengers;
}
