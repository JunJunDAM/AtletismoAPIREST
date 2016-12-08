package com.example.repository;

import com.example.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by jun on 05/12/2016.
 */
public interface AtletaRepository extends JpaRepository<Atleta, Long>{
    List<Atleta> findByNacionalidadContains(String nacionalidad);
    List<Atleta> findByFechaNacimientoBefore(LocalDate fechaNacimiento);
    List<Atleta> findByNombreIs(String nombre);
}
