package com.dev.houseutils.houseutils.repository;

import com.dev.houseutils.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
