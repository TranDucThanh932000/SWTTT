/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin2
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of inputListUser method, of class UserManager.
     */
    @Test
    public void testInputListUser() {
        System.out.println("inputListUser");
        UserManager instance = new UserManager();
        instance.inputListUser();
        int size=instance.getListUser().size();
        if(size!=0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }

    /**
     * Test of addUser method, of class UserManager.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        UserManager instance = new UserManager();
        instance.inputListUser();
        int size1=instance.getListUser().size();
        String name="test";
        String pass="test";
        int type=3;
        instance.addUser(6,name,pass,type);
        int size2 = instance.getListUser().size();
        if(size1==size2){
            assertEquals(true, false);
        }else{
            assertEquals(true, true);
        }
    }

    /**
     * Test of updateListUser method, of class UserManager.
     */
    @Test
    public void testUpdateListUser() {
        System.out.println("updateListUser");
        UserManager instance = new UserManager();
        instance.inputListUser();
        String name="afterUpdate";
        String pass="update";
        int type=3;
        instance.updateListUser(6,name,pass,type);
        List<User> list= instance.getListUser();
        for(User u:list){
            if(u.getUserName().equals("afterUpdate") && u.getPassword().equals("update")){
                assertEquals(true, true);
                return;
            }
        }
        assertEquals(false, true);
    }
    /**
     * Test of changePassword method, of class UserManager.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        UserManager instance = new UserManager();
        instance.inputListUser();
        String name="goodgame";
        String pass="testtt";
        instance.changePassword(name,pass);
        List<User> list = instance.getListUser();
        for(User l:list){
            if(l.getUserName().equals("goodgame") && l.getPassword().equals("testtt")){
                assertEquals(true, true);
                return;
            }
        }
        assertEquals(true, false);
    }
    /**
     * Test of deleteUser method, of class UserManager.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        UserManager instance = new UserManager();
        int id=6;
        instance.inputListUser();
        int size1 = instance.getListUser().size();
        instance.deleteUser(id);
        int size2= instance.getListUser().size();
        if(size1!= size2){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }

    }





    /**
     * Test of updateFile method, of class UserManager.
     */
    @Test
    public void testUpdateFile() {
        System.out.println("updateFile");
        UserManager instance = new UserManager();
        instance.inputListUser();
        List<User> list= instance.getListUser();
        int size1=list.size();
        String name="test";
        String pass="test";
        int type=3;
        instance.addUser(6,name,pass,type);
        instance.updateFile();
        int size2=list.size();
        if(size1 != size2){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }
    
}
