package pl.sda.covidvavapp.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.covidvavapp.api.model.Patient;
import pl.sda.covidvavapp.api.model.Question;
import pl.sda.covidvavapp.api.model.Vaccination;
import pl.sda.covidvavapp.repository.PatientEntity;
import pl.sda.covidvavapp.repository.QuestionEntity;
import pl.sda.covidvavapp.repository.QuestionRepository;
import pl.sda.covidvavapp.repository.VaccinationEntity;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public List<Question> getAllQuestion() throws IOException {
        return questionRepository.getAll()
                .stream()
                .map(this::mapToQuestion)
                .collect(Collectors.toList());
    }

    private Question mapToQuestion(QuestionEntity entity) {
        return Question.builder()
                .id(entity.getId())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .build();
    }

}
