package com.example.service;

import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jun on 05/12/2016.
 */
@Service
public class MedallaService {
    @Autowired private MedallaRepository mRepository;
    @Autowired private AtletaRepository aRepository;

    public void medallas(){
        Medalla m1 = new Medalla(TipoMedalla.ORO,"Atletismo");
        m1.setAtleta("Usain");
        Medalla m2 = new Medalla(TipoMedalla.PLATA,"Atletismo");
        m2.setAtleta("Mohamed");
        Medalla m3 = new Medalla(TipoMedalla.BRONZE,"Atletismo");
        m3.setAtleta("Askana");

        mRepository.save(m1);
        mRepository.save(m2);
        mRepository.save(m3);

        System.out.println("Atletas con el oro : ");
        System.out.println(mRepository.findByTipoMedalla(TipoMedalla.ORO));
        System.out.println("Atletas con el plata : ");
        System.out.println(mRepository.findByTipoMedalla(TipoMedalla.PLATA));
        System.out.println("Atletas con el bronze : ");
        System.out.println(mRepository.findByTipoMedalla(TipoMedalla.BRONZE));
    }



}
