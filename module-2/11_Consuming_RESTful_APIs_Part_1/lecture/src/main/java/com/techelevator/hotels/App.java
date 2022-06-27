package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();

            if (menuSelection == 1) {
                Hotel[] allHotels = hotelService.listHotels(); //we built the method in hotelservice.java, call it here
                consoleService.printHotels(allHotels); //feed the hotel[] we just created into the console to print it out

            } else if (menuSelection == 2) {
                System.out.println("Not implemented");
            } else if (menuSelection == 3) {
                 Review[] reviewsFoHotel1 = hotelService.getReviewsByHotelId(1);
                 consoleService.printReviews(reviewsFoHotel1);
            } else if (menuSelection == 4) {
                System.out.println("Not implemented");
            } else if (menuSelection == 5) {
                System.out.println("Not implemented");
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
