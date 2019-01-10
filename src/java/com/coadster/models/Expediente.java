/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coadster.models;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author cperalta
 */
@XmlRootElement
public class Expediente {
    private int     no_expediente;
    private String  fecha_ultima_consulta;
    private String  tipo_sangre;
    private List<Alergia> Alergias;

    public int getNo_expediente() {
        return no_expediente;
    }

    public void setNo_expediente(int no_expediente) {
        this.no_expediente = no_expediente;
    }

    public String getFecha_ultima_consulta() {
        return fecha_ultima_consulta;
    }

    public void setFecha_ultima_consulta(String fecha_ultima_consulta) {
        this.fecha_ultima_consulta = fecha_ultima_consulta;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public List<Alergia> getAlergias() {
        return Alergias;
    }

    public void setAlergias(List<Alergia> Alergias) {
        this.Alergias = Alergias;
    }
 
   
}
