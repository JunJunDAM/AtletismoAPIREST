package com.example.service;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by jun on 05/12/2016.
 */
@Service
public class AtletaService {
    @Autowired private AtletaRepository aRepository;

    public void Atletas(){
        Atleta a1 = new Atleta("Usain","Bolt","Jamaica", LocalDate.of(1989,8,21));
        Atleta a2 = new Atleta("Mohamed","Farah","Reino Unido",LocalDate.of(1983,3,23));
        Atleta a3 = new Atleta("Jesse","Owens","USA",LocalDate.of(1913,9,12));
        Atleta a4 = new Atleta("Ylena","Isinbayeva","Rusia",LocalDate.of(1982,6,3));
        Atleta a5 = new Atleta("Nadia","Comaneci","Rumania",LocalDate.of(1961,11,12));
        Atleta a6 = new Atleta("Askana","Miankova","Bielorrusia",LocalDate.of(1982,3,28));

        aRepository.save(a1);
        aRepository.save(a2);
        aRepository.save(a3);
        aRepository.save(a4);
        aRepository.save(a5);
        aRepository.save(a6);

        System.out.println("Buscar atleta por nombre [Mohamed] : ");
        System.out.println(aRepository.findByNombreContains("Mohamed"));
        System.out.println("Buscar atleta por nacionalidad [Jamaica] : ");
        System.out.println(aRepository.findByNacionalidadContains("Jamaica"));
        System.out.println("Buscar atleta por fecha nacimiento antes que [1920,1,1] : ");
        System.out.println(aRepository.findByFechaNacimientoBefore(LocalDate.of(1920,1,1)));
    }
}
