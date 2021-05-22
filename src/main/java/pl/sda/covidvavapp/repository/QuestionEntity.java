package pl.sda.covidvavapp.repository;


import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class QuestionEntity {

    @Setter
    private Long id;
    private String question;
    private String answer;
}
