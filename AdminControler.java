/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.ArrayList;
import java.util.Scanner;
import static projectssw.Projectssw.admin;

/**
 *
 * @author Access
 */
public class AdminControler {

    Scanner input = new Scanner(System.in);
    protected ArrayList<String> DiscountAreas = new ArrayList<String>();

    public void addDiscountAreas(String discountAreas) {

        DiscountAreas.add(discountAreas);
    }

    public ArrayList<String> getDiscountAreas() {
        return DiscountAreas;
    }

    void verifyDrivers(Admin admin) {
        String verify;
        System.out.println("if you want to verify (Y) or (N) if did not want to verify ");
        for (int i = 0; i < admin.getPending_drivers().size(); i++) {
            System.out.print("Do you want to verify " + admin.getPending_drivers().get(i).getUserName() + " / " + admin.getPending_drivers().get(i).getDrivingLicense() + " : ");
            verify = input.next();
            if (verify.equalsIgnoreCase("Y")) {
                admin.getPending_drivers().get(i).setVeryfied(true);
                admin.addDriver(admin.getPending_drivers().get(i));
                admin.addUser(admin.getPending_drivers().get(i));
                admin.getPending_drivers().remove(i);
                i--;

            } else if (verify.equalsIgnoreCase("N")) {
                admin.getPending_drivers().get(i).setVeryfied(false);

            } else {
                System.out.println("plz enter y or n only");
                continue;
            }
        }

    }

    void SusbendDriver(Admin admin) {
        String Suspend;
        System.out.println("if you want to Suspend (Y) or (N) if did not want to Suspend ");
        for (int i = 0; i < admin.getDrivers().size(); i++) {
            System.out.print("Do you want to Suspend " + admin.getDrivers().get(i).getUserName() + " / " + admin.getDrivers().get(i).getNumDriver() + " : ");
            Suspend = input.next();
            if (Suspend.equalsIgnoreCase("Y")) {
                admin.getDrivers().get(i).setSusbend(true);

            } else if (Suspend.equalsIgnoreCase("N")) {
                admin.getDrivers().get(i).setSusbend(false);
                //System.out.println(admin.getPending_drivers().get(i).isVeryfied()+" this Driver not veryfied"); 

            } else {
                System.out.println("plz enter y or n only");
                continue;
            }
        }

    }

    void SusbendClient(Admin admin) {
        String Suspend;
        System.out.println("if you want to Suspend (Y) or (N) if did not want to Suspend ");
        for (int i = 0; i < admin.getClients().size(); i++) {
            System.out.print("Do you want to Suspend " + i + 1 + "." + admin.getClients().get(i).getUserName() + " / " + admin.getClients().get(i).getNumClient() + " : ");
            Suspend = input.next();
            if (Suspend.equalsIgnoreCase("Y")) {
                admin.getClients().get(i).setSusbend(true);
                System.out.println("Susbend= " + admin.getClients().get(i).isSusbend());

            } else if (Suspend.equalsIgnoreCase("N")) {
                admin.getClients().get(i).setSusbend(false);
                //System.out.println(admin.getPending_drivers().get(i).isVeryfied()+" this Driver not veryfied"); 

            } else {
                System.out.println("plz enter y or n only");
                continue;
            }
        }

    }

    void updateAfterPrice(Driver driver) {
        Event event = new Event();

        for (int i = 0; i < admin.getDrivers().size(); i++) {
            if (admin.getDrivers().get(i).getPassword().equals(driver.getPassword())) {
                event.setDriverName(admin.getDrivers().get(i).getUserName());
                event.setEventName("Driver Put A Price");
                event.setEventTime(admin.getDrivers().get(i).getEventTime());
                event.setPrice(admin.getDrivers().get(i).Offer);
                for (int j = 0; j < driver.clientsRequsts.size(); j++) {
                    if (admin.getDrivers().get(i).clientsRequsts.get(j).acceptOffer) {
                        event.setClientrName(admin.getDrivers().get(i).clientsRequsts.get(j).getUserName());
                    }
                }
            }
        }
        admin.addEvent(event);
    }

    void updateAfterAcceptPrice(Client client) {
        Event event = new Event();

        for (int i = 0; i < admin.getClients().size(); i++) {
            if (admin.getClients().get(i).getPassword().equals(client.getPassword())) {
                event.setDriverName(admin.getClients().get(i).ride.getDriverName());
                event.setEventName("Client Accept Driver Offer");
                event.setEventTime(admin.getClients().get(i).getEventTime());
                event.setPrice(admin.getClients().get(i).ride.getPriceAfterDiscount());
                event.setClientrName(admin.getClients().get(i).getUserName());
//                
            }
        }
        admin.addEvent(event);
    }

    void updateAfterArrivedToSource(Driver driver) {
        Event event = new Event();

        for (int i = 0; i < admin.getDrivers().size(); i++) {
            if (admin.getDrivers().get(i).getPassword().equals(driver.getPassword())) {
                event.setDriverName(admin.getDrivers().get(i).getUserName());
                event.setEventName("Driver arrived to user location ");
                event.setEventTime(admin.getDrivers().get(i).getEventTime());
                event.setPrice(admin.getDrivers().get(i).Offer);
                for (int j = 0; j < driver.clientsRequsts.size(); j++) {
                    if (admin.getDrivers().get(i).clientsRequsts.get(j).acceptOffer) {
                        event.setClientrName(driver.clientsRequsts.get(j).getUserName());
                    }
                }
//                event.setClientrName(driver.clientsRequsts.get(i).getUserName());
//                
            }
        }
        admin.addEvent(event);

    }

    void updateAfterArrivedToDest(Driver driver) {
        Event event = new Event();

        for (int i = 0; i < admin.getDrivers().size(); i++) {
            if (admin.getDrivers().get(i).getPassword().equals(driver.getPassword())) {
                event.setDriverName(admin.getDrivers().get(i).getUserName());
                event.setEventName("Driver arrived to user destenation ");
                Integer time = Integer.parseInt(admin.getDrivers().get(i).getEventTime()) + 2;
                event.setEventTime(time.toString());
                event.setPrice(admin.getDrivers().get(i).Offer);
                for (int j = 0; j < driver.clientsRequsts.size(); j++) {
                    if (admin.getDrivers().get(i).clientsRequsts.get(j).acceptOffer) {
                        event.setClientrName(driver.clientsRequsts.get(j).getUserName());
                    }
                }
                //event.setClientrName(driver.clientsRequsts.get(i).getUserName());
               
            }
        }
        admin.addEvent(event);

    }

    void displayEvents() {
        for (int i = 0; i < admin.getEvents().size(); i++) {
            System.out.println(admin.getEvents().get(i).getEventName() + " --> in time " + admin.getEvents().get(i).getEventTime()
                    + " Driver : " + admin.getEvents().get(i).getDriverName()
                    + " and the price is  " + admin.getEvents().get(i).getPrice()
                    + " for Client :  " + admin.getEvents().get(i).getClientrName());
        }

    }

//    public void checkDiscountArea(Client client) {
//        for (int i = 0; i < DiscountAreas.size(); i++) {
//            if (client.getRide().getDestnation().equalsIgnoreCase(DiscountAreas.get(i))) {
//                CalcDiscount(client.getRide());
//            }
//
//        }
//
//    }
//
//    public double CalcDiscount(Ride ride) {
//        double discountPercentage = 0.1;
//        ride.setPriceAfterDiscount((double)ride.getPriceAfterDiscount() * discountPercentage);
//        return ride.getPriceAfterDiscount();
//
//    }

}
