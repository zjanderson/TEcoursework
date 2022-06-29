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
    @GetMapping("/reservations")
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
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
