package com.GuestHouseBaltadzhiev.web;

import com.GuestHouseBaltadzhiev.model.Binding.ReservationBinding;
import com.GuestHouseBaltadzhiev.model.service.ReservationServiceModel;
import com.GuestHouseBaltadzhiev.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final ModelMapper modelMapper;

    public ReservationController(ReservationService reservationService, ModelMapper modelMapper){
        this.reservationService = reservationService;
        this.modelMapper = modelMapper;
    }
    @ModelAttribute("reservationBinding")
    public ReservationBinding creatingReservationBinding(){
        return new ReservationBinding ();
    }

    @GetMapping("/reservation")
    public String checkFOrReservationGet(Model model){
        model.addAttribute ("reservationBinding", new ReservationBinding ());

        return "index";
    }

    @PostMapping("/reservation")
    public String checkForReservation(@Valid ReservationBinding reservationBinding,
                                      Model model,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes,
                                      HttpSession httpSession){


        model.addAttribute ("reservationBinding", new ReservationBinding ());
        if (bindingResult.hasErrors ()) {
            redirectAttributes.addFlashAttribute ("reservationBinding", reservationBinding);
            redirectAttributes.addFlashAttribute ("org.springframework.validation.BindingResult.reservationBinding", bindingResult);
            return "redirect:/home#book-a-table";
        }

        ReservationServiceModel reservationServiceModel = modelMapper
                .map (reservationBinding, ReservationServiceModel.class);
        reservationService.registerReservation (reservationServiceModel);
        reservationService.sendEmailToMe (reservationServiceModel);

        return "redirect:/home#gallery";
    }
}
