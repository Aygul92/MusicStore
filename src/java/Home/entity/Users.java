/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home.entity;

/**
 *
 * @author apple
 */
public class Users {
    
    private String Users_name;
    private String password;
private String first_name;


    public Users(String Users_name, String password, String first_name) {
        this.Users_name = Users_name;
        this.password = password;
        this.first_name = first_name;
    }
   

    public Users() {
    }

    public String getUsers_name() {
        return Users_name;
    }

    public void setUsers_name(String Users_name) {
        this.Users_name = Users_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    
    
    
    
}
