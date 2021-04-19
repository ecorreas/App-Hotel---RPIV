package com.rp4.reservaservice.ConsumerMensagem;

import com.rp4.reservaservice.model.Hotel;
import com.rp4.reservaservice.model.Usuario;
import com.rp4.reservaservice.repository.HotelRepository;
import com.rp4.reservaservice.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

public class HotelConsumerMensagem {

    private HotelRepository hotelRepository;
    @Autowired
    public HotelConsumerMensagem(HotelRepository hotelRepository){
        this.hotelRepository= hotelRepository;
    }
    @RabbitListener(queues = {"${crud.rabbitmq.queueUsuario}"})
    public void consumer(@Payload Hotel hotel){
        hotelRepository.save(hotel);
    }
}
