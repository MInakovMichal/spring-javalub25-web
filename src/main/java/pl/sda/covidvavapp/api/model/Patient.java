package pl.sda.covidvavapp.api.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private List<Vaccination> doneVacs;
    private List<Vaccination> plannedVacs;
}
