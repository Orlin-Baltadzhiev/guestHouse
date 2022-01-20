package com.GuestHouseBaltadzhiev.service;

import com.GuestHouseBaltadzhiev.model.service.ReservationServiceModel;

public interface ReservationService {
    void registerReservation(ReservationServiceModel reservationServiceModel);

    void sendEmailToMe(ReservationServiceModel reservationServiceModel);
}
