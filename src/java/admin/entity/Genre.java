/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.entity;

/**
 *
 * @author apple
 */
public class Genre {
    private int genre_id;
    private String genre_name;

    public Genre() {
    }

    public int getGenre_id() {
        return genre_id;
    }

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public String getGenre_name() {
        return genre_name;
    }
    
    
    
    
}
