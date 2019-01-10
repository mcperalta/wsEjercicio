package com.coadster.controller;

import com.coadster.app.DBConnection;
import com.coadster.app.PIDPlatformException;
import com.coadster.models.Alergia;
import com.coadster.models.Expediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author cperalta
 */
public class ExpedienteController {
    
    
    public Expediente findExp(int id) throws PIDPlatformException{
        String sql = "select noExpediente, DATE_FORMAT(fecha_consulta, \"%d/%m/%y\") as fecha_consulta,tipo_sangre from expedientes where noExpediente="+id;
        Connection cn = new DBConnection().connect();
        Expediente e = new Expediente();
        ArrayList<Alergia> data = new ArrayList<>();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.first()){
                e.setNo_expediente(rs.getInt("noExpediente"));
                e.setFecha_ultima_consulta(rs.getString("fecha_consulta"));
                e.setTipo_sangre(rs.getString("tipo_sangre"));
            }
            String sql2 = "Select noExpediente, DATE_FORMAT(fecha_alergia, \"%d/%m/%y\") as fecha_alergia, nombre_alergia,medicamento from hospitaldb.alergias where noExpediente="+id;
            rs = st.executeQuery(sql2); 
            while(rs.next()){
                Alergia a = new Alergia();
                a.setNombre(rs.getString("nombre_alergia"));
                a.setFecha_alta(rs.getString("fecha_alergia"));
                a.setMedicamento(rs.getString("medicamento"));
                data.add(a);
                e.setAlergias(data);
            }
            cn.close();
            return e;
            
        } catch (SQLException ex) {
            throw new PIDPlatformException("Internal Error: "+ex.getMessage());
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                throw new PIDPlatformException(ex.getMessage());
            }
        }
    }
   
    
}
