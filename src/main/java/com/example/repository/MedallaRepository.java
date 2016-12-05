package com.example.repository;

import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jun on 05/12/2016.
 */
public interface MedallaRepository extends JpaRepository<Medalla, Long>{
    List<Medalla> findByTipoMedalla(TipoMedalla tipoMedalla);
}
