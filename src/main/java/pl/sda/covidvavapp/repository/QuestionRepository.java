package pl.sda.covidvavapp.repository;


import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class QuestionRepository {

    private Long QUESTION_ID = 0L;
    private List<QuestionEntity> questions = new ArrayList<>();

    public List<QuestionEntity> getAll() throws IOException {

        BufferedReader bufReader = new BufferedReader(new FileReader("C:\\files\\SDA\\spring-javalub25-web\\src\\main\\java\\pl\\sda\\covidvavapp\\quastion.txt"));
        String line = bufReader.readLine();
        while (line != null) {
            questions.add(new QuestionEntity(++QUESTION_ID, line, "ID: " + QUESTION_ID));
            line = bufReader.readLine();
        }
        bufReader.close();

        return questions;
    }
}
