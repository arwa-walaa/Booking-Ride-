/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Access
 */
public class Admin  {
    Scanner input = new Scanner(System.in);
    boolean suspended = true;
    AdminControler admincon=new AdminControler();
    //System DataBase
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Driver> drivers = new ArrayList<Driver>();
    private ArrayList<Driver> pending_drivers = new ArrayList<Driver>();
    private ArrayList<Event> Events = new ArrayList<Event>();
    private ArrayList<User> users = new ArrayList<User>();
    
    
    //Admin info
    private String userName ,password;
   
    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void pendingDrivers(Driver driver) {
        pending_drivers.add(driver);
    }

    public ArrayList<Driver> getPending_drivers() {
        return pending_drivers;
    }

    public void displayUsers() {

        for (int i = 0; i < users.size(); i++) {
            System.out.println("user " + (i + 1) + " information ");
            users.get(i).display();
        }

    }
   

    public void SuspendDriver(Driver driver, Boolean b) {
        driver.setSusbend(b);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public void Register(Admin admin)
    {
        System.out.println("please enter Name: ");
        admin.setUserName(input.next());
        System.out.println("please enter password : ");
        admin.setPassword(input.next());
       
        
    }
     public boolean login(Admin admin){
         System.out.println("please enter Name: ");
        admin.setUserName(input.next());
        System.out.println("please enter password : ");
        admin.setPassword(input.next());
         
         if(admin.getUserName().equals(this.getUserName())&& admin.getPassword().equals(this.getPassword())){
              System.out.println("loged in sucessfuly ");
              return true;
         }
         else
         {
             System.out.println("oops! you username or password is wrong");
             return false;
         }
     }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.Events = Events;
    }
    public void addEvent(Event event){
        Events.add(event);
    }
     

   

}
