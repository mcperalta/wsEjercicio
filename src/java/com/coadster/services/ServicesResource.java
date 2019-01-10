/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coadster.services;

import com.coadster.app.PIDPlatformException;
import com.coadster.controller.ExpedienteController;
import com.coadster.models.Expediente;
import com.coadster.models.Pizza;
import com.coadster.models.ResponseWS;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cperalta
 */
@Path("/accounts/{id}/record")
public class ServicesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PizzasRecurso
     */
    public ServicesResource() {
    }

    /**
     * Retrieves representation of an instance of pizzaPackage.ServicesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public ResponseWS getXml(@PathParam("id") int id) throws PIDPlatformException {
        //TODO return proper representation object
//        return "<dato>Ejemplo coleccion</dato>";
        ResponseWS rs;
        Expediente exp= new ExpedienteController().findExp(id);
        System.out.println(exp.getNo_expediente());
        if(exp.getNo_expediente()> 0)
        rs= new ResponseWS(200, "PeticionCompleta", exp);
        else
        rs= new ResponseWS(400, "El id de usuario no existe");   
//        return new Pizza(1, "Carbonara", "Nuestra más afamada"); 
//        throw new UnsupportedOperationException();
        return rs;
    }

    /**
     * POST method for creating an instance of PizzaRecurso
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(String content) {
        //TODO
//        return Response.created(context.getAbsolutePath()).build();
          System.out.println("por aqui");
          return Response.ok().build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
//    public PizzaRecurso getPizzaRecurso(@PathParam("id") String id) {
      public String getPizzaRecurso(@PathParam("id") String id) {
        System.out.println("reclamamos elemento");
//        return PizzaRecurso.getInstance(id);
         return "Complicando los mappings";
    }
}
