package com.example.domain;

import javax.persistence.*;

/**
 * Created by jun on 05/12/2016.
 */
@Entity
public class Medalla {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Enumerated(EnumType.STRING) private TipoMedalla tipoMedalla;
    private String competicion;
    @ManyToOne private Atleta atleta;

    public Medalla() {
    }

    public Medalla(TipoMedalla tipoMedalla, String competicion) {
        this.tipoMedalla = tipoMedalla;
        this.competicion = competicion;
    }

    @Override
    public String toString() {
        return "***** Medalla ["  + id + "]" + "\n" +
                "***** Tipo de Medalla=" + tipoMedalla + "\n" +
                "***** Competicion='" + competicion + "\n" +
                "***** Atleta=" + atleta ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medalla medalla = (Medalla) o;

        if (id != medalla.id) return false;
        if (tipoMedalla != medalla.tipoMedalla) return false;
        if (competicion != null ? !competicion.equals(medalla.competicion) : medalla.competicion != null) return false;
        return atleta != null ? atleta.equals(medalla.atleta) : medalla.atleta == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tipoMedalla != null ? tipoMedalla.hashCode() : 0);
        result = 31 * result + (competicion != null ? competicion.hashCode() : 0);
        result = 31 * result + (atleta != null ? atleta.hashCode() : 0);
        return result;
    }
}
