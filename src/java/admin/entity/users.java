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
public class users {
    
      private int users_id;
  private String users_name;
    private String password;
    private String firstname;
    private String Lastname;
    private int Cart_id;
    private int Orders_id;
    private int yorum_id;
    private int usersRole_id;

    public int getUsers_id() {
        return users_id;
    }

    public users(int users_id, String users_name, String password, String firstname, String Lastname, int Cart_id, int Orders_id, int yorum_id, int usersRole_id) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.password = password;
        this.firstname = firstname;
        this.Lastname = Lastname;
        this.Cart_id = Cart_id;
        this.Orders_id = Orders_id;
        this.yorum_id = yorum_id;
        this.usersRole_id = usersRole_id;
    }

    public users(int users_id, String users_name, String password) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.password = password;
    }

    public users(int users_id, String users_name, String password, String firstname, String Lastname) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.password = password;
        this.firstname = firstname;
        this.Lastname = Lastname;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getPassword() {
        return password;
    }

    public users() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public int getCart_id() {
        return Cart_id;
    }

    public void setCart_id(int Cart_id) {
        this.Cart_id = Cart_id;
    }

    public int getOrders_id() {
        return Orders_id;
    }

    public void setOrders_id(int Orders_id) {
        this.Orders_id = Orders_id;
    }

    public int getYorum_id() {
        return yorum_id;
    }

    public void setYorum_id(int yorum_id) {
        this.yorum_id = yorum_id;
    }

    public int getUsersRole_id() {
        return usersRole_id;
    }

    public void setUsersRole_id(int usersRole_id) {
        this.usersRole_id = usersRole_id;
    }
    
    
    
}
