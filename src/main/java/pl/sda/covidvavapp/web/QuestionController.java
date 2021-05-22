package pl.sda.covidvavapp.web;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.covidvavapp.service.QuestionService;

import java.io.IOException;

@Controller
@RequestMapping("/questionnaire")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @GetMapping
    public ModelAndView displayQuestionsPage() throws IOException {
        ModelAndView mav = new ModelAndView("questionnaire");
        mav.addObject("questionnaire", questionService.getAllQuestion());
        return mav;
    }



}
