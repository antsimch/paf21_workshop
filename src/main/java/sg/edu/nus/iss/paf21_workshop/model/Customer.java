package sg.edu.nus.iss.paf21_workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    private int id;

    private String firstName;

    private String lastName;
}
