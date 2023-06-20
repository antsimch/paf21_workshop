package sg.edu.nus.iss.paf21_workshop.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    
    private Customer customer;

    private Room room;

    private LocalDate startDate;

    private LocalDate endDate;

    private int totalCost;
}
