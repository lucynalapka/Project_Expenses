package pl.coderslab.expenses.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.expenses.model.Trip;

import pl.coderslab.expenses.repository.TripRepository;
import pl.coderslab.expenses.repository.UserRepository;
import pl.coderslab.expenses.service.TripService;
import pl.coderslab.expenses.service.impl.TripServiceImpl;

import javax.validation.Valid;



@Controller
@AllArgsConstructor
@RequestMapping("/trips")
public class TripController {

    private final TripRepository tripRepository;
    private final TripService tripService;
    private final UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", tripService.findAll());
        return "/trips-list";

    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) {
        return this.tripService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("users", userRepository.findAll());

        return "/trip-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submit(@Valid Trip trip, BindingResult result) {
//        if (result.hasErrors()) {
//            return "trip-form";
//        }
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String formUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("trip", tripService.get(id));
        model.addAttribute("users", userRepository.findAll());
        return "/trip-form";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String formUpdate(@Valid Trip trip, BindingResult result) {
        if (result.hasErrors()) {
            return "trips/update";
        }
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String formDelete(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }





//    private final TripDao tripDao;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String list(Model model) {
//        model.addAttribute("items", tripDao.findAll());
//        return "/trips-list";
//
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.GET)
//    public String form(Model model){
//        model.addAttribute("trip",new Trip());
//        return "/trip-form";
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.POST)
//    public String submit(@ModelAttribute Trip trip){
//        tripDao.saveTrip(trip);
//        return "redirect:/trips";
//    }
//
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
//    public String formDelete(@PathVariable Long id) {
//        tripDao.deleteTrip(tripDao.findById(id));
//        return "redirect:/trips";
//    }
//
//    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
//    public String formUpdate(@PathVariable Long id, Model model) {
//        model.addAttribute("trip", tripDao.findById(id));
//        return "/trip-form";
//    }
//    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
//    public String formUpdate( @ModelAttribute Trip trip) {
//       tripDao.editTrip(trip);
//        return "redirect:/trips";
//    }



    }




