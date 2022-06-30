package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
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

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) throws HotelNotFoundException {
        return hotelDao.get(id);
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        return reservationDao.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelID
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelID) throws HotelNotFoundException {
        return reservationDao.findByHotel(hotelID);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     * @param hotelID
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation, @PathVariable("id") int hotelID)
            throws HotelNotFoundException {
        return reservationDao.create(reservation, hotelID);
    }

    @RequestMapping(path = "/reservations/{reservationId}", method = RequestMethod.PUT)
    public Reservation updateReservation(@PathVariable int reservationId,
                                         @Valid @RequestBody Reservation reservation) throws ReservationNotFoundException{
        reservation.setId(reservationId);

        return reservationDao.update(reservation, reservationId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/reservations/{reservationId}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int reservationId) throws ReservationNotFoundException {
        reservationDao.delete(reservationId);
    }
}
