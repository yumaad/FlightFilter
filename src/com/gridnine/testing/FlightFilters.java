package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilters {

    public static List<Flight> filterDepartedBeforeNow(List<Flight> flights, LocalDateTime now) {
        return flights.stream()
                .filter(f -> f.getSegments().stream().anyMatch(s -> s.getDepartureDate().isBefore(now)))
                .collect(Collectors.toList());
    }

    public static List<Flight> filterSegmentArrivalBeforeDeparture(List<Flight> flights) {
        return flights.stream()
                .filter(f -> f.getSegments().stream().anyMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate())))
                .collect(Collectors.toList());
    }

    public static List<Flight> filterTotalGroundTimeExceeds(List<Flight> flights, Duration threshold) {
        return flights.stream()
                .filter(f -> {
                    List<Segment> segs = f.getSegments();
                    if (segs.size() < 2) return false;
                    Duration totalGround = Duration.ZERO;
                    for (int i = 0; i < segs.size() - 1; i++) {
                        LocalDateTime arrive = segs.get(i).getArrivalDate();
                        LocalDateTime nextDepart = segs.get(i + 1).getDepartureDate();
                        if (nextDepart.isAfter(arrive)) {
                            totalGround = totalGround.plus(Duration.between(arrive, nextDepart));
                        } else {
                        }
                        if (totalGround.compareTo(threshold) > 0) return true;
                    }
                    return totalGround.compareTo(threshold) > 0;
                })
                .collect(Collectors.toList());
    }
}
