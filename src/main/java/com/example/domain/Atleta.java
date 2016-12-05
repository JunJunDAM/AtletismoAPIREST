package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun on 05/12/2016.
 */
@Entity
public class Atleta {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private  long id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    @OneToMany(mappedBy = "Atleta") @JsonIgnore private Set<Medalla> medallas = new HashSet<>();

    public Atleta() {
    }

    public Atleta(String nombre, String apellido, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "***** Atleta [" + id + "]" + "\n" +
                "***** Nombre: " + nombre + '\'' + "\n" +
                "***** Apellido: " + apellido + '\'' + "\n" +
                "***** Nacionalidad: " + nacionalidad + '\'' + "\n" +
                "***** Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "***** Medallas: " + medallas + "\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Medalla> getMedallas() {
        return medallas;
    }

    public void setMedallas(Set<Medalla> medallas) {
        this.medallas = medallas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atleta atleta = (Atleta) o;

        if (id != atleta.id) return false;
        if (nombre != null ? !nombre.equals(atleta.nombre) : atleta.nombre != null) return false;
        if (apellido != null ? !apellido.equals(atleta.apellido) : atleta.apellido != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(atleta.nacionalidad) : atleta.nacionalidad != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(atleta.fechaNacimiento) : atleta.fechaNacimiento != null)
            return false;
        return medallas != null ? medallas.equals(atleta.medallas) : atleta.medallas == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (medallas != null ? medallas.hashCode() : 0);
        return result;
    }
}
