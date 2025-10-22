package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    public Segment(LocalDateTime dep, LocalDateTime arr) {
        this.departureDate = dep;
        this.arrivalDate = arr;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return "[" + departureDate.format(fmt) + "|" + arrivalDate.format(fmt) + "]";
    }
}
