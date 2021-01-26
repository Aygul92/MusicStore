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
public class Album {
    
    private int album_id;
    private Artist artist;
    private String title;
    private int price;
    private Genre genre;

    public Album() {
    }

    public Album(int album_id, Artist artist, String title, int price, Genre genre) {
        this.album_id = album_id;
        this.artist = artist;
        this.title = title;
        this.price = price;
        this.genre = genre;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    
    
}
