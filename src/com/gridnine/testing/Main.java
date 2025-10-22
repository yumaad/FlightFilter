package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("\nAll flights:");
        flights.forEach(System.out::println);
        System.out.println();

        LocalDateTime now = LocalDateTime.now();

        System.out.println("1) Flights with departure before current time (to be excluded):");
        List<Flight> departed = FlightFilters.filterDepartedBeforeNow(flights, now);
        departed.forEach(System.out::println);
        System.out.println();

        System.out.println("2) Flights with segment where arrival is before departure (invalid segments):");
        List<Flight> invalidSeg = FlightFilters.filterSegmentArrivalBeforeDeparture(flights);
        invalidSeg.forEach(System.out::println);
        System.out.println();

        System.out.println("3) Flights where total ground time between segments exceeds 2 hours:");
        List<Flight> longGround = FlightFilters.filterTotalGroundTimeExceeds(flights, Duration.ofHours(2));
        longGround.forEach(System.out::println);
        System.out.println();
    }
}
