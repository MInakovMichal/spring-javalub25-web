package pl.sda.covidvavapp.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.sda.covidvavapp.api.model.Facility;
import pl.sda.covidvavapp.service.FacilityService;

@Controller
@RequestMapping("/facility")
@AllArgsConstructor
public class FacilityController {

    private FacilityService facilityService;

    @GetMapping
    public ModelAndView displayFacilitiesPage() {
        ModelAndView mav = new ModelAndView("facilities");
        mav.addObject("facilities", facilityService.getAll());
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView displayAddFacilityPage() {
        ModelAndView mav = new ModelAndView("changeFacility");
        mav.addObject("facility", new Facility());
        return mav;
    }

    @GetMapping("/edit/{facilityId}")
    public ModelAndView displayEditFacilityPage(@PathVariable Long facilityId) {
        ModelAndView mav = new ModelAndView("changeFacility");
        mav.addObject("facility", facilityService.getOne(facilityId));
        return mav;
    }

    @PostMapping
    public RedirectView handleFacilityChange(@ModelAttribute Facility facility) {
        if (facility.getId() == null) {
            facilityService.create(facility);
        } else {
            facilityService.update(facility);
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/facility");

        return redirectView;
    }

    @GetMapping("/delete/{facilityId}")
    public RedirectView deleteFacility(@PathVariable Long facilityId) {
        ModelAndView mav = new ModelAndView("facilities");
        mav.addObject("facility", facilityService.remove(facilityId));

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/facility");

        return redirectView;
    }

}
