package com.ideas;

import com.ideas.enums.CustomerType;
import com.ideas.enums.RateType;
import com.ideas.utils.DateUtil;

import java.time.LocalDate;
import java.util.*;

public class ReservationSystem {
    private final List<Hotel> hotels;

    public ReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Hotel findCheapestHotel(LocalDate arrivalDate, LocalDate departureDate) {
        Map<Hotel, Double> hotels = new HashMap<>();
        this.hotels.forEach(hotel -> {
            int numberOfWeekdays = DateUtil.getNumberOfWeekdaysBetween(arrivalDate, departureDate);
            int numberOfWeekends = DateUtil.getNumberOfWeekendsBetween(arrivalDate, departureDate);
            double weekdayRate = findRateValueUsingRateType(hotel, RateType.WEEKDAY);
            double weekendRate = findRateValueUsingRateType(hotel, RateType.WEEKEND);
            double totalRate = (numberOfWeekdays * weekdayRate) + (numberOfWeekends * weekendRate);
            hotels.put(hotel, totalRate);
        });
        return Collections.min(hotels.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Hotel findCheapestHotelByCustomer(LocalDate arrivalDate, LocalDate departureDate, CustomerType customerType) {
        return null;
    }

    private Double findRateValueUsingRateType(Hotel hotel, RateType rateType){
        Rate rate = hotel.getRates().stream().filter(r -> r.getType() == rateType).findAny().orElse(null);
        if(null != rate){
            return rate.getValue();
        }
        return 0.0;
    }
}