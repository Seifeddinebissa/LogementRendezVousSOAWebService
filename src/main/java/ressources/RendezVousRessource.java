package ressources;

import entities.RendezVous;
import metiers.RendezVousBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("rendezvous")
public class RendezVousRessource {
    RendezVousBusiness rvb = new RendezVousBusiness();

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRendezVous(RendezVous rendezVous) {
        if (rvb.addRendezVous(rendezVous)) {
            return Response.ok().entity("created!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListRendezVous() {
        return Response.ok().entity(rvb.getListeRendezVous()).build();
    }

//    @GET
//    @Path("list/{ref}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getListRendezVousByRef(@PathParam("ref") int ref) {
//        List<RendezVous> lrv = new ArrayList<>();
//        for (RendezVous r : rvb.getListeRendezVous()) {
//            if (r.getLogement().getReference() == ref) {
//                lrv.add(r);
//            }
//        }
//        return Response.ok().entity(lrv).build();
//    }

    @GET
    @Path("list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRendezVousById(@PathParam("id") int id) {
        return Response.ok().entity(rvb.getRendezVousById(id)).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteRendezVous(@PathParam("id") int id) {
        if(rvb.deleteRendezVous(id)){
            return Response.ok().entity("deleted!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).entity("rendez vous n'existe pas").build();
        }
    }

    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRendezVous(@PathParam("id") int id, RendezVous rendezVous) {
        if (rvb.updateRendezVous(id,rendezVous)) {
            return Response.ok().entity("updated!").build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
