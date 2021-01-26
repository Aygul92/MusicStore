/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.users;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.ConnectionManager;

/**
 *
 * @author apple
 */
public class usersDao implements DAO<users> {

    @Override
    public void create(users o) {
      try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into users (users_id,users_name, password, Firstname,lastnamr) values ('" + ((users) o).getUsers_id() + "', '" + ((users) o).getUsers_name() + "',sha1('" + ((users) o).getPassword() + "'),'" + ((users) o).getFirstname() + "','" + ((users) o).getLastname()+ "'";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }


    @Override
    public ArrayList<users> list() {
        
        
        ArrayList<users> cList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from users";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cList.add(new users(rs.getInt("users_id"), rs.getString("users_name"), rs.getString("password"), rs.getString("firstname"),  rs.getString("lastanme")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cList;
    }

    @Override
    public ArrayList<users> pagedList(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(users o) {
        
        
        try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from users where users_id=" + o.getUsers_id();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public users detail(String st) {
        users user = null;
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from users where users_name=" + st;
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			user = new users(rs.getInt("users_id"), rs.getString("users_name"), rs.getString("password"), rs.getString("firstname"),  rs.getString("lastanme"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
    }
    
    
    
    
    
    public users login(users u) {
		users tmp = null;
		try {

			String np = usersDao.encryptPassword(u.getPassword());

			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from users where users_name='" + u.getUsers_name() + "' and password='" + np+ "'";
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				tmp = new users(rs.getInt("users_id"), rs.getString("users_name"), rs.getString("password"), rs.getString("firstname"),rs.getString("lastname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(usersDao.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(usersDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tmp;
	}
    private static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(password.getBytes("UTF-8"));

		return new BigInteger(1, crypt.digest()).toString(16);
	}
}
