package com.gato.gatito.controller;

import com.gato.gatito.model.entity.Gatito;
import com.gato.gatito.services.GatitoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;//devuelve status, objeto
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gatito")
@CrossOrigin("*") //todos los puertos pueden acceder

public class GatitoController {
    private final GatitoService gatitoService;

    public GatitoController(GatitoService gatitoService) {
        this.gatitoService = gatitoService;
    }

    @GetMapping
    public ResponseEntity <List<Gatito>> getGatitos (){
        return new ResponseEntity<>(gatitoService.getAllGatito(), HttpStatus.OK);
    }

    @GetMapping ("{id}")
    public ResponseEntity <Gatito> getGatitobyId (@PathVariable long id){
        return new ResponseEntity<>(gatitoService.getGatitoById(id), HttpStatus.OK);
    }

    @PostMapping//guardar un nuevo gatito
    public ResponseEntity <Gatito> saveGatito (@RequestBody Gatito gatito){
        return new ResponseEntity<>(gatitoService.saveGatito(gatito), HttpStatus.CREATED );
    }

    @PutMapping ("{id}")//UPDATE
    public ResponseEntity <Gatito> updateGatito (@PathVariable long id, @RequestBody Gatito gatito){
        return new ResponseEntity<>(gatitoService.updateGatito(gatito,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteGatitobyId (@PathVariable long id){
        return new ResponseEntity<>(gatitoService.deleteGatito(id),HttpStatus.NO_CONTENT);
    }
}
