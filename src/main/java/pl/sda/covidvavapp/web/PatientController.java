package pl.sda.covidvavapp.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.sda.covidvavapp.api.model.NewPatient;
import pl.sda.covidvavapp.service.PatientService;

@Controller
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;

    @GetMapping
    public ModelAndView displayPatientsPage() {
        ModelAndView mav = new ModelAndView("patients");
        mav.addObject("patients", patientService.getAllPatients());
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView displayAddPatientPage() {
        ModelAndView mav = new ModelAndView("addPatient");
        mav.addObject("newPatient", new NewPatient());
        return mav;
    }

    @PostMapping
    public RedirectView handleAddPatient(@ModelAttribute NewPatient newPatient) {
        patientService.registerPatient(newPatient);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/patient");

        return redirectView;
    }
}