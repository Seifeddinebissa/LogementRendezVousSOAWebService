package ressources;

import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("logement")
public class LogementRessource {
    LogementBusiness lb = new LogementBusiness();
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListLogement(){
        return Response.ok().entity(lb.getLogements()).build();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLogement(Logement logement){
        if (lb.addLogement(logement)) {
            return Response.ok().entity("created!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("list/{delegation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListLogementByDelegation(@PathParam("delegation") String delegation){
        return Response.ok().entity(lb.getLogementsByDeleguation(delegation)).build();
    }
    @DELETE
    @Path("delete/{ref}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteLogement(@PathParam("ref") int ref){
        if (lb.deleteLogement(ref)) {
            return Response.ok().entity("deleted!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).entity("logement n'existe pas").build();
        }
    }

    @PUT
    @Path("update/{ref}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UpdateLogement(@PathParam("ref") int ref, Logement logement){
        if (lb.updateLogement(ref,logement)) {
            return Response.ok().entity("updated!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).entity("logement n'existe pas").build();
        }
    }
    @GET
    @Path("get/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementByRef(@PathParam("ref") int ref){
        return Response.ok().entity(lb.getLogementsByReference(ref)).build();
    }
}
