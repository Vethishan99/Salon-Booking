package com.vethishan.salon.service.service;

import com.vethishan.salon.service.modal.Salon;
import com.vethishan.salon.service.payload.dto.SalonDTO;
import com.vethishan.salon.service.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId);

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId);

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCityName(String city);
}
