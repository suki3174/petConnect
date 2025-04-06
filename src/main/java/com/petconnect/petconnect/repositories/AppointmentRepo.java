package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
}
