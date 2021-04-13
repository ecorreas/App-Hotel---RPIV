package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.QuartoDTO;

import com.rp4.hotelaria.interfaces.IQuartoService;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.model.Quarto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {
    private IQuartoService quartoService;

    @Autowired
    public QuartoController(IQuartoService service) {

        this.quartoService = service;
    }

    @PostMapping("/salvar")
    public void saveQuarto(@RequestBody QuartoDTO quartoDTO) {
        Quarto quarto = new Quarto();
        quarto.setHotel(quartoDTO.getHotel());
        quarto.setNumeroDoQuarto(quartoDTO.getNumeroDoQuarto());
        quarto.setDescricao(quartoDTO.getDescricao());
        quarto.setPreco(quartoDTO.getPreco());
        quarto.setAdicionalDoQuarto(quartoDTO.getAdicionalDoQuarto());
        quartoService.salvarQuarto(quarto);

    }

    @GetMapping("/quarto/{id}")
    public ResponseEntity<?> pegarQuartoPeloId(@PathVariable("id") Long id) {
        Quarto quarto = quartoService.getQuartoById(id);
        return new ResponseEntity<>(quarto, HttpStatus.OK);
    }

    @PutMapping("/quarto/atualizar")
    @ApiOperation(value = "Atualizar Quarto")
    public Quarto atualizarQuarto(@RequestBody Quarto quarto) {

        return quartoService.atualizarQuarto(quarto);
    }

    @DeleteMapping("/quarto/excluir/{id}")
    public void deleteQuarto(@PathVariable("id") Long id) {
        quartoService.excluirQuarto(id);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> pegarTodosQuartos() {
        List<Quarto> quartos = quartoService.pegarTodosQuartos();
        return new ResponseEntity<>(quartos, HttpStatus.OK);
    }

    @GetMapping("/quarto/numero/{numero}")
    public Quarto getQuartoByNumero(int numeroDoQuarto) {
        Quarto quarto = quartoService.getQuartoByNumero(numeroDoQuarto);
        return quarto;
    }
}
