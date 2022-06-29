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

//we will need a @RestController annotation at the class leven to get the program that this is a controller!!
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
    @RequestMapping(path = "/hotels", method = RequestMethod.GET) //this @RequestMapping is UNIQUE, it tells Spring which method to use
    public List<Hotel> list(@RequestParam(required = false, defaultValue = "") String city,
                            @RequestParam(required = false) String state) {

        if (city.equals("") && state == null) {
            return hotelDao.list();

        }  if (state == null) {
            List<Hotel> hotels = hotelDao.list();
            List<Hotel> filterHotels = new ArrayList<>();

            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getCity().equalsIgnoreCase(city)) {
                    filterHotels.add(hotel);
                }
            }
            return filterHotels;

        } if (city.equals("")) {
            List<Hotel> hotels = hotelDao.list();
            List<Hotel> filterHotels = new ArrayList<>();

            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filterHotels.add(hotel);
                }
            }
        }

            //if i get both variables

            List<Hotel> hotels = hotelDao.list();
            List<Hotel> filterHotels = new ArrayList<>();

            for (Hotel hotel : hotels) {
                if (hotel.getAddress().getCity().equalsIgnoreCase(city)
                        && hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filterHotels.add(hotel);
                }
            }
            return filterHotels;
            
    }

        /*
    Filter by nothing
    GET http://localhost:8080/hotels

    Filter by city
    GET http://localhost:8080/hotels?city=Pittsburgh

    Filter by state
    GET http://localhost:8080/hotels?state=Ohio

    Filter by city AND state
    GET http://localhost:8080/hotels?city=Columbus&state=Ohio
     */




    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) { //the names of these methods don't matter at all
        return hotelDao.get(id);
    }


    @RequestMapping(path = "/hotels", method =  RequestMethod.POST)
    public Hotel createHotel(@RequestBody Hotel hotelToCreate) {
        hotelDao.create(hotelToCreate); //can't return this, because hotelDAO create method is void

        return  hotelDao.get(hotelToCreate.getId());
    }



//    @RequestMapping(path = "/reservations", method = RequestMethod.GET)  //this is one way, or we can use helper method below
    @GetMapping("/reservations")
    public List<Reservation> listReservations() {

        return  reservationDao.findAll();
    }

    //path option http://localhost:8080/reservations?hotelID={id}
    //other http://localhost:8080/hotels/{id}/reservations

    @GetMapping("/hotels/{id}/reservations")
    public List<Reservation> findReservationsForHotel(@PathVariable(name = "id") int hotelId) {

        return reservationDao.findByHotel(hotelId);

    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservatioById(@PathVariable(name = "id") int reservationId) {
        return reservationDao.get(reservationId);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation createReservation(Reservation reservationToCreate) {
        return reservationDao.create(reservationToCreate, reservationToCreate.getHotelID());
    }


}
