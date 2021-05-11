package com.rp4.reservaPasseioTuristico.ConsumerMensagem;

import com.rp4.reservaPasseioTuristico.model.Hotel;
import com.rp4.reservaPasseioTuristico.repository.HotelRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HotelConsumerMensagem {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelConsumerMensagem(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @RabbitListener(queues = {"${crud.rabbitmq.queueHotel}"})
    public void consumer(@Payload Hotel hotel) {
        hotelRepository.save(hotel);


    }
}
