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
public class Artist {
    private int artist_id;
    private String artist_name;

    public int getArtist_id() {
        return artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public Artist() {
    }

    public Artist(int artist_id, String artist_name) {
        this.artist_id = artist_id;
        this.artist_name = artist_name;
    }
    
    
    
    
}
