package com.ideas;

import com.ideas.enums.RateType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationSystemTest {

    @Test
    void findCheapestHotel() {
        Rate rate1 = new Rate(20.0, RateType.WEEKDAY);
        Rate rate2 = new Rate(110.0, RateType.WEEKEND);
        Rate rate3 = new Rate(20.0, RateType.WEEKDAY);
        Rate rate4 = new Rate(10.0, RateType.WEEKEND);
        Rate rate5 = new Rate(100.0, RateType.WEEKDAY);
        Rate rate6 = new Rate(150.0, RateType.WEEKEND);
        Hotel miamiBeach = new Hotel(List.of(rate1, rate2), "Miami Beach");
        Hotel miamiDowntown = new Hotel(List.of(rate3, rate4), "Miami Downtown");
        Hotel miamiMidtown = new Hotel(List.of(rate5, rate6), "Miami Midtown");
        List<Hotel> hotels = List.of(miamiBeach, miamiDowntown, miamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotels);
        LocalDate arrivalDate = LocalDate.of(2023,1,1);
        LocalDate departureDate = LocalDate.of(2023,1,10);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(arrivalDate, departureDate);
        assertEquals("Miami Downtown", cheapestHotel.getName());
    }
}