package com.techelevator.hotels;

import com.techelevator.hotels.model.Activity;
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

                Hotel[] allHotels = hotelService.listHotels();
                consoleService.printHotels(allHotels);

            } else if (menuSelection == 2) {

                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);

            } else if (menuSelection == 3) {

                Hotel hotel1 = hotelService.getHotelById(1);
                consoleService.printHotel(hotel1);

            } else if (menuSelection == 4) {

                Review[] reviewsForHotel1 = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviewsForHotel1);

            } else if (menuSelection == 5) {

                Hotel[] hotelsWith3Stars = hotelService.getHotelsByStarRating(3);
                consoleService.printHotels(hotelsWith3Stars);

            } else if (menuSelection == 6) {

                Activity recreationalActivity = hotelService.getActivityOfType("recreational");
                System.out.println("Activity: " + recreationalActivity.getActivity());
                System.out.println("Type: " + recreationalActivity.getType());
                System.out.println("Participants: " + recreationalActivity.getParticipants());

            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
