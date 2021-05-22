package pl.sda.covidvavapp.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        if (newPatient.getId() == null) {
            patientService.registerPatient(newPatient);
        } else {
            patientService.updatePatient(newPatient);
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/patient");

        return redirectView;
    }

    @GetMapping("/edit/{patientId}")
    public ModelAndView displayEditPatientPage(@PathVariable Long patientId) {
        ModelAndView mav = new ModelAndView("changePatient");
        mav.addObject("patient", patientService.getPatient(patientId));
        return mav;
    }

    @GetMapping("/delete/{patientId}")
    public RedirectView deletePatient(@PathVariable Long patientId) {
        ModelAndView mav = new ModelAndView("patients");
        mav.addObject("patient", patientService.deletePatient(patientId));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/patient");

        return redirectView;
    }

    @GetMapping("/deleteVaccination/{patientId}")
    public RedirectView deleteVaccination(@PathVariable Long patientId) {
        ModelAndView mav = new ModelAndView("patients");
        mav.addObject("patient", patientService.deleteVaccination(patientId));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/patient");

        return redirectView;
    }


}
