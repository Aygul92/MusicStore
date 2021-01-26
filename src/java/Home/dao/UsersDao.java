/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home.dao;

import Home.entity.Users;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utility.ConnectionManager;

/**
 *
 * @author apple
 */
public class UsersDao {
    
    public void create(Users u) {
      try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into users (users_name, password, Firstname) values ('" + ((Users) u).getUsers_name() + "', '" + ((Users) u).getPassword() + "','" + ((Users) u).getFirst_name() + "'";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }
    
    
    
    
    
    
}
