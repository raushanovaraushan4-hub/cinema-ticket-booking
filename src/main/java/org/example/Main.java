package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n=== CINEMA TICKET BOOKING ===");
                System.out.println("1. Add new movie");
                System.out.println("2. Add new viewer");
                System.out.println("3. Show all movies");
                System.out.println("4. Show movies sorted by title");
                System.out.println("5. Show all viewers");
                System.out.println("6. Update movie title");
                System.out.println("7. Update viewer name");
                System.out.println("8. Delete movie");
                System.out.println("9. Delete viewer");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Movie ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Title: "); String title = sc.nextLine();
                        System.out.print("Genre: "); String genre = sc.nextLine();
                        cinema.addMovie(new Movie(id, title, genre));
                    }
                    case 2 -> {
                        System.out.print("Viewer ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        cinema.addViewer(new Viewer(id, name, email));
                    }
                    case 3 -> {
                        List<Movie> movies = cinema.getMovies();
                        for(Movie m : movies) System.out.println(m);
                    }
                    case 4 -> {
                        List<Movie> movies = cinema.getMoviesSorted();
                        for(Movie m : movies) System.out.println(m);
                    }
                    case 5 -> {
                        List<Viewer> viewers = cinema.getViewers();
                        for(Viewer v : viewers) System.out.println(v);
                    }
                    case 6 -> {
                        System.out.print("Movie ID to update: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("New title: "); String title = sc.nextLine();
                        cinema.updateMovieTitle(id, title);
                    }
                    case 7 -> {
                        System.out.print("Viewer ID to update: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("New name: "); String name = sc.nextLine();
                        cinema.updateViewerName(id, name);
                    }
                    case 8 -> {
                        System.out.print("Movie ID to delete: "); int id = sc.nextInt();
                        cinema.deleteMovie(id);
                    }
                    case 9 -> {
                        System.out.print("Viewer ID to delete: "); int id = sc.nextInt();
                        cinema.deleteViewer(id);
                    }
                    case 0 -> { sc.close(); return; }
                    default -> System.out.println("Wrong choice!");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}