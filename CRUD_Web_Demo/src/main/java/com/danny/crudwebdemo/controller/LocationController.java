package com.danny.crudwebdemo.controller;

import com.danny.crudwebdemo.entity.Location;
import com.danny.crudwebdemo.repository.LocationRepository;
import com.danny.crudwebdemo.service.LocationService;
import com.danny.crudwebdemo.utils.EmailUtil;
import com.danny.crudwebdemo.utils.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService service;

    @Autowired
    private LocationRepository repository;

    @Autowired
    private ReportUtil reportUtil;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, RedirectAttributes redirectAttrs) {
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id " + locationSaved.getId();
        redirectAttrs.addFlashAttribute("msg", msg);
//        emailUtil.sendEmail("mohamad.aslam.0864@gmail.com", "Location saved", "Location saved successfully");
        return "redirect:/displayLocations";
    }

    @GetMapping("/displayLocations")
    public String displayLocations(Model model) {
        List<Location> allLocations = service.getAllLocations();
        model.addAttribute("locs", allLocations);
        return "displayLocations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, RedirectAttributes redirectAttrs) {
        service.deleteLocation(id);
        String del = "Location with id " + id + " has been successfully deleted";
        redirectAttrs.addFlashAttribute("del", del);
        return "redirect:/displayLocations";
    }

    @GetMapping("/editLocation")
    public String editLocation(@RequestParam("id") int id, Model model) {
        Location location = service.getLocationById(id);
        model.addAttribute("location", location);
        return "updateLocation";
    }

    @PostMapping("/updateLocation")
    public String updateLocation(@ModelAttribute("location") Location location, RedirectAttributes redirectAttrs) {
        Location locationUpdated = service.saveLocation(location);
        String msg = "Location updated with id " + locationUpdated.getId();
        redirectAttrs.addFlashAttribute("msg", msg);
        return "redirect:/displayLocations";
    }

    @GetMapping("/generateReport")
    public String generateReport() {
        String path = servletContext.getRealPath("/");
        List<Object[]> data = repository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }
}