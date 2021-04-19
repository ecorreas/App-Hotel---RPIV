package com.rp4.reservaservice.ConsumerMensagem;

import com.rp4.reservaservice.model.Usuario;
import com.rp4.reservaservice.repository.UsuarioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConsumerMensagem {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioConsumerMensagem(UsuarioRepository usuarioRepository1){
        this.usuarioRepository= usuarioRepository1;
    }

    @RabbitListener(queues = {"${crud.rabbitmq.queueUsuario}"})
    public void consumer(@Payload Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
