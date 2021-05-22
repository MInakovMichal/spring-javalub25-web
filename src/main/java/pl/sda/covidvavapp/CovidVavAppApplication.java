package pl.sda.covidvavapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.sda.covidvavapp.config.VaccinationTypeConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SpringBootApplication
@EnableConfigurationProperties(value = {VaccinationTypeConfig.class})

public class CovidVavAppApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CovidVavAppApplication.class, args);


//        BufferedReader bufReader = new BufferedReader(new FileReader("C:\\files\\SDA\\spring-javalub25-web\\src\\main\\java\\pl\\sda\\covidvavapp\\quastion.txt"));
//        HashMap<String, String> listOfLines = new HashMap<>();
//        String line = bufReader.readLine();
//        while (line != null) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println(line + "?");
//            String an = scanner.nextLine();
//            listOfLines.put(line, an);
//            line = bufReader.readLine();
//        }
//        bufReader.close();
//        System.out.println("Content of ArrayLiList:");
//        System.out.println(listOfLines);

    }

}
