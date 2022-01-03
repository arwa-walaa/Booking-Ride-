/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

/**
 *
 * @author Access
 */
public class AdminDiscount extends CondimentDecorator{
      Ride ride;

    public AdminDiscount(Ride ride) {
        this.ride = ride;
    }
     @Override
    public double CalcDiscount() {
        if (ride.client.numberofRequestRide == 1) {
            double discountPercentage = 0.1;
            ride.setPriceAfterDiscount((double) ride.getPriceAfterDiscount() * discountPercentage);

        }
        return ride.getPriceAfterDiscount();

    }
    public void checkDiscountArea(Client client,Admin admin) {
        for (int i = 0; i < admin.admincon.DiscountAreas.size(); i++) {
            if (client.getRide().getDestnation().equalsIgnoreCase(admin.admincon.DiscountAreas.get(i))) {
                CalcDiscount();
            }

        }

    }
    
}
