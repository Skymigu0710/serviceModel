package com.gato.gatito.repository;

import com.gato.gatito.model.entity.Gatito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatitoRepository extends JpaRepository <Gatito,Long>{

}
