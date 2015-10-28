/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misterfour
 */
public class Admin {
    private String idAdmin;
    private String username;
    private String password;
    
    public Admin(String idAdmin, String username, String password){
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }
    
    public Admin(Admin a){
        this.idAdmin = a.getIdAdmin();
        this.username = a.getUsername();
        this.password = a.getPassword();
    }
    
    public String getIdAdmin(){
        return this.idAdmin;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }

}
    
    