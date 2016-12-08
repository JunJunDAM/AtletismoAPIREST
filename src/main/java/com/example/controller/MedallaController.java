package com.example.controller;

import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jun on 05/12/2016.
 */
@RestController @RequestMapping("/medalla")
public class MedallaController {
    @Autowired private MedallaRepository medallaRepository;
    @GetMapping public List<Medalla> getMedallas(){
        return medallaRepository.findAll();
    }

    @GetMapping("/groupby/tipo") public Map<TipoMedalla, List<Medalla>> getMedallasByTipo(){
        return medallaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Medalla::getTipoMedalla));
    }
}
