/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Album;
import admin.entity.Songs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utility.ConnectionManager;

/**
 *
 * @author apple
 */
public class SongsDao  implements DAO<Songs> {

    private ArtistDao arD;

    public ArtistDao getArD() {
         if ( this.arD == null )
			this.arD = new ArtistDao();
        return arD;
    }

    public void setArD(ArtistDao arD) {
        this.arD = arD;
    }
    
    
    
    
    @Override
    public void create(Songs so) {
        
         try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into Songs (song_id,song_name,price,Artist_id) values ('" + ((Songs) so).getSong_id() + "', '" + ((Songs) so).getSong_name() + "','" + ((Songs) so).getPrice() + "' ,'" + ((Songs) so).getArtist().getArtist_name()+ "' ";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        
        
        
        
    }

    

    @Override
    public ArrayList<Songs> list() {
         ArrayList<Songs> sogList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from Songs";
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				sogList.add(new Songs(rs.getInt("song_id"), rs.getString("song_name"),rs.getInt("price"),this.getArD().detail(rs.getString("artist_name"))));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sogList;
    }

    @Override
    public ArrayList<Songs> pagedList(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Songs son) {
        
        try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from Songs where song_id=" + son.getSong_id();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public Songs detail(String st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
