package me.assel.assignment.objects;

import me.assel.assignment.dao.MovieDAO;
import me.assel.assignment.dao.ViewerDAO;

import java.util.List;

public class Cinema {

    public void addMovie(Movie m) throws Exception {
        MovieDAO.insertMovie(m);
    }

    public void addViewer(Viewer v) throws Exception {
        ViewerDAO.insertViewer(v);
    }

    public List<Movie> getMovies() throws Exception {
        return MovieDAO.readMovies();
    }

    public List<Movie> getMoviesSorted() throws Exception {
        return MovieDAO.readMoviesSortedByTitle();
    }

    public List<Viewer> getViewers() throws Exception {
        return ViewerDAO.readViewers();
    }

    public void updateMovieTitle(int id, String title) throws Exception {
        MovieDAO.updateMovieTitleById(id, title);
    }

    public void updateViewerName(int id, String name) throws Exception {
        ViewerDAO.updateViewerNameById(id, name);
    }

    public void deleteMovie(int id) throws Exception {
        MovieDAO.deleteMovieById(id);
    }

    public void deleteViewer(int id) throws Exception {
        ViewerDAO.deleteViewerById(id);
    }
}