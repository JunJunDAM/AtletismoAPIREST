package com.example.controller;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jun on 05/12/2016.
 */
@RestController @RequestMapping("atletas")
public class AtletaController {
    @Autowired private AtletaRepository atletaRepository;
    @GetMapping public List<Atleta> getAtletaList(){
        return atletaRepository.findAll();
    }

    @GetMapping("/{nacionalidad}") public List<Atleta> getAtletasByNacionalidad(@PathVariable String nacionalidad){
        return atletaRepository.findAll().parallelStream().filter(atleta -> atleta.getNacionalidad().toLowerCase().equals(nacionalidad.toLowerCase())).collect(Collectors.toList());
    }

    @GetMapping("/groupby/nacionalidad") public Map<String, List<Atleta>> groupAtletasByNacionalidad(){
        return atletaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Atleta::getNacionalidad));
    }
}
