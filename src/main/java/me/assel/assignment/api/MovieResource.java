package me.assel.assignment.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.assel.assignment.dao.MovieDAO;
import me.assel.assignment.objects.Movie;

import java.util.List;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @GET
    public List<Movie> getAllMovies() throws Exception {
        return MovieDAO.readMovies();
    }

    @GET
    @Path("/{id}")
    public Response getMovieById(@PathParam("id") int id) throws Exception {
        Movie movie = MovieDAO.findMovieById(id);
        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(movie).build();
    }

    @POST
    public Response addMovie(Movie movie) throws Exception {
        MovieDAO.insertMovie(movie);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMovie(@PathParam("id") int id, Movie movie) throws Exception {
        MovieDAO.updateMovieTitleById(id, movie.getTitle());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") int id) throws Exception {
        MovieDAO.deleteMovieById(id);
        return Response.noContent().build();
    }
}
