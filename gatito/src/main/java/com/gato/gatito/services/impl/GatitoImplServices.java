package com.gato.gatito.services.impl;

import com.gato.gatito.model.entity.Gatito;
import com.gato.gatito.repository.GatitoRepository;
import com.gato.gatito.services.GatitoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GatitoImplServices implements GatitoService {

    private final GatitoRepository gatitoRepository;

    public GatitoImplServices(GatitoRepository gatitoRepository) {
        this.gatitoRepository = gatitoRepository;
    }

    @Override
    public Gatito getGatitoById(Long id) {
        Optional<Gatito> gatitoOptional= gatitoRepository.findById(id);
        if(gatitoOptional.isPresent())
            return gatitoOptional.get();
        else
            throw new RuntimeException("No se encontró el gatito uwu");
    }

    @Override
    public List<Gatito> getAllGatito() {
        return gatitoRepository.findAll();
    }

    @Override
    public Gatito saveGatito(Gatito gatito) {
        return gatitoRepository.save(gatito);
    }

    @Override
    public Gatito updateGatito(Gatito gatito, Long id) {
        gatito.setId(id);
        return gatitoRepository.save(gatito);
    }

    @Override
    public String deleteGatito(Long id) {
        try {
            gatitoRepository.deleteById(id);
            return "Se elimino correctamente el gatitoxd" + id;
        }catch (Exception e){
            return "No hay gatito xd";
        }

    }
}
