package com.rp4.servicos.repository;

import com.rp4.servicos.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findReservaById(Long id);
}
