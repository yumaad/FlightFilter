package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {
    public static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

        return Arrays.asList(
                new Flight(List.of(
                        new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2))
                )),
                new Flight(List.of(
                        new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusHours(2))
                )),
                new Flight(List.of(
                        new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(2))
                )),
                new Flight(Arrays.asList(
                        new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(7))
                )),
                new Flight(Arrays.asList(
                        new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5))
                )),
                new Flight(Arrays.asList(
                        new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(1)),
                        new Segment(threeDaysFromNow.plusHours(2), threeDaysFromNow.plusHours(1)) // invalid
                ))
        );
    }
}
