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
public class Songs {
    
    private int song_id;
     private String song_name;
    private int price;
    private Artist artist ;

    public Songs(int song_id, String song_name, int price, Artist artist) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.price = price;
        this.artist = artist;
    }

    public Songs() {
    }

    
    
    
    
    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    

    
    
}
