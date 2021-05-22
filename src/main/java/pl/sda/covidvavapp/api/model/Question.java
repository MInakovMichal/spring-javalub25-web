package pl.sda.covidvavapp.api.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String question;
    private String answer;

}
