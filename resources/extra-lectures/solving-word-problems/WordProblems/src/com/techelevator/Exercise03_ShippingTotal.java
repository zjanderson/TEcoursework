package com.techelevator;

public class Exercise03_ShippingTotal {

    /*
    Scamper Shipping Company specializes in small, local deliveries.
    The problems below ask you to implement the logic to calculate a shipping amount for a package.
     */

    // You can use these constants in your solutions.
    public static  final int MAX_WEIGHT_POUNDS = 40;
    public static final double UP_TO_40_LB_RATE = 0.50;
    public static final double OVER_40_LB_RATE = 0.75;
    public static final double DEFAULT_40_LB_RATE = MAX_WEIGHT_POUNDS *UP_TO_40_LB_RATE;


    public static void main(String[] args) {
        double total1 = calculateShippingTotal(10);
        double total2 = calculateShippingTotal(25);
        double total3 = calculateShippingTotal(45);


        double t1 = calculateShippingTotal(10, false); // ➔ 5.0
        double t2 = calculateShippingTotal(10, true) ; //➔ 4.5
        double t3 = calculateShippingTotal(25, false); // ➔ 12.5
        double t4 = calculateShippingTotal(25, true); // ➔ 11.25
        double t5 = calculateShippingTotal(45, false); // ➔ 23.75
        double t6 = calculateShippingTotal(45, true) ; //➔ 21.375


        double c1 = calculateShippingTotal(10, 0) ; //➔ 5.0
        double c2 = calculateShippingTotal(10, 0.1) ; //➔ 4.5
        double c3 = calculateShippingTotal(25, 0.15); // ➔ 10.625
        double c4 = calculateShippingTotal(45, 0.2); //➔ 19.0

        System.out.println("");
    }
    /*
    Scamper Shipping Company charges $0.50 per pound up to 40 pounds. After that, it's $0.75 for each additional pound.
    Implement the logic needed to calculate the shipping rate when provided a weight in pounds.

    Examples:
    calculateShippingTotal(10) ➔ 5.0
    calculateShippingTotal(25) ➔ 12.5
    calculateShippingTotal(45) ➔ 23.75
     */
    public static double calculateShippingTotal(int weightPounds) {
        double total = 0.0;

        if (weightPounds <= MAX_WEIGHT_POUNDS) {
            total = weightPounds * UP_TO_40_LB_RATE;
        } else {
            total = ((weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE) + DEFAULT_40_LB_RATE;// (MAX_WEIGHT_POUNDS * UP_TO_40_LB_RATE ) ;
        }


        return total;
    }

    /*
    Scamper Shipping Company now allows customers to provide a discount code to give them 10% off of their order.
    Implement the logic to calculate the correct shipping rate when provided a weight in pounds and a boolean value for hasDiscount.

    Examples:
    calculateShippingTotal(10, false) ➔ 5.0
    calculateShippingTotal(10, true) ➔ 4.5
    calculateShippingTotal(25, false) ➔ 12.5
    calculateShippingTotal(25, true) ➔ 11.25
    calculateShippingTotal(45, false) ➔ 23.75
    calculateShippingTotal(45, true) ➔ 21.375
     */
    public static double calculateShippingTotal(int weightPounds, boolean hasDiscount) {
        double total = 0.0;
        double preDiscountTotal = calculateShippingTotal(weightPounds);

        total = (hasDiscount) ? (preDiscountTotal * 0.9) : preDiscountTotal;
        return total;
    }

    /*
    As the business grows for Scamper Shipping Company, they now offer discounts in various amounts.
    Implement the logic to calculate the shipping rate when provided a weight in pounds
    and a discount percentage (for example, 0.1 = 10% off).

    Examples:
    calculateShippingTotal(10, 0) ➔ 5.0
    calculateShippingTotal(10, 0.1) ➔ 4.5
    calculateShippingTotal(25, 0.15) ➔ 10.625
    calculateShippingTotal(45, 0.2) ➔ 19.0
     */
    public static double calculateShippingTotal(int weightPounds, double discountPercentage) {

        double preDiscountTotal = calculateShippingTotal(weightPounds);

        double calculatedPercentageAmount = (1 - discountPercentage);

        return preDiscountTotal * calculatedPercentageAmount;
    }
}
