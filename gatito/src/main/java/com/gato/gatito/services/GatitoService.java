package com.gato.gatito.services;

import com.gato.gatito.model.entity.Gatito;

import java.util.List;

public interface GatitoService {
    public Gatito getGatitoById(Long id);
    public List<Gatito> getAllGatito();
    public Gatito saveGatito(Gatito gatito);
    public Gatito updateGatito(Gatito gatito, Long id);
    public String deleteGatito(Long id);
}
