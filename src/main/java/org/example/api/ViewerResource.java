package org.example.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.ViewerDAO;
import org.example.objects.Viewer;

import java.util.List;

@Path("/viewers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViewerResource {

    @GET
    public List<Viewer> getAllViewers() throws Exception {
        return ViewerDAO.readViewers();
    }

    @GET
    @Path("/{id}")
    public Response getViewerById(@PathParam("id") int id) throws Exception {
        Viewer viewer = ViewerDAO.findViewerById(id);
        if (viewer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(viewer).build();
    }

    @POST
    public Response addViewer(Viewer viewer) throws Exception {
        ViewerDAO.insertViewer(viewer);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateViewer(@PathParam("id") int id, Viewer viewer) throws Exception {
        ViewerDAO.updateViewerNameById(id, viewer.getName());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteViewer(@PathParam("id") int id) throws Exception {
        ViewerDAO.deleteViewerById(id);
        return Response.noContent().build();
    }
}
