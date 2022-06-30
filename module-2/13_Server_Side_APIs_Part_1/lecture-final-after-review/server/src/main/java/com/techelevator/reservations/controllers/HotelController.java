package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required = false, defaultValue = "") String city,
                            @RequestParam(required = false) String state) {

        List<Hotel> hotels = hotelDao.list();

        // I got neither
        if (city.equals("") && state == null) {
            return hotels;
        }

        // I got only city
        if (state == null) {
            List<Hotel> filteredHotels = new ArrayList<>();

            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getCity().equalsIgnoreCase(city)) {
                    filteredHotels.add(hotel);
                }
            }

            return filteredHotels;
        }

        // I got only state
        if (city.equals("")) {
            List<Hotel> filteredHotels = new ArrayList<>();

            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filteredHotels.add(hotel);
                }
            }

            return filteredHotels;
        }

        // I got both city and state
        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (hotel.getAddress().getCity().equalsIgnoreCase(city)
                    && hotel.getAddress().getState().equalsIgnoreCase(state)) {
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;
    }

    /*
        Filter by nothing
        GET http://localhost:8080/hotels

        Filter by city
        GET http://localhost:8080/hotels?city=Pittsburgh

        Filter by state
        GET http://localhost:8080/hotels?state=Ohio

        Filter by city and state
        GET http://localhost:8080/hotels?city=Columbus&state=Ohio
     */


    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    @RequestMapping(path = "/hotels", method = RequestMethod.POST)
    public Hotel createHotel(@RequestBody Hotel hotelToCreate) {
        hotelDao.create(hotelToCreate);

        return hotelDao.get(hotelToCreate.getId());
    }



//    @RequestMapping(path = "/reservations", method = RequestMethod.GET)

    /*
        GET http://localhost:8080/reservations - get all reservations

        GET http://localhost:8080/reservations?name_like={something here} - filter by name (contains search)

        GET http://localhost:8080/reservations?guests_lte={some number} - filter by guests

        GET http://localhost:8080/reservations?name_like={something here}&guests_lte={some number} - filter by both
     */
    @GetMapping("/reservations")
    public List<Reservation> listReservations(@RequestParam(name="name_like", required = false) String nameLike,
                                              @RequestParam(name="guests_lte", required = false, defaultValue = "-1") int guestsLte) {

        List<Reservation> allReservations = reservationDao.findAll();

        if (nameLike == null && guestsLte == -1) {
            return allReservations;
        }

        List<Reservation> filteredReservations = new ArrayList<>();

        // if I only receive name filter
        if (nameLike != null && guestsLte == -1) {
            for (Reservation r : allReservations) {
                String lowerCaseFullName = r.getFullName().toLowerCase();
                String lowerCaseNameLike = nameLike.toLowerCase();

                if (lowerCaseFullName.contains(lowerCaseNameLike)) {
                    filteredReservations.add(r);
                }
            }

            return filteredReservations;
        }

        // if I only receive guest filter
        if (guestsLte > 0 && nameLike == null) {
            for (Reservation r : allReservations) {
                if (r.getGuests() <= guestsLte) {
                    filteredReservations.add(r);
                }
            }

            return filteredReservations;
        }


        // if I receive both name and guests filters
        for (Reservation r : allReservations) {
            String lowerCaseFullName = r.getFullName().toLowerCase();
            String lowerCaseNameLike = nameLike.toLowerCase();

            if (lowerCaseFullName.contains(lowerCaseNameLike) && r.getGuests() <= guestsLte) {
                filteredReservations.add(r);
            }
        }

        return filteredReservations;
    }

    // http://localhost:8080/reservations?hotelID={id}
    // http://localhost:8080/hotels/1/reservations

//    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    @GetMapping("/hotels/{hotelId}/reservations")
    public List<Reservation> findReservationsForHotel(@PathVariable int hotelId) {
        return reservationDao.findByHotel(hotelId);
    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable(name="id") int reservationId) {
        return reservationDao.get(reservationId);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservationToCreate) {
        return reservationDao.create(reservationToCreate, reservationToCreate.getHotelID());
    }
}
