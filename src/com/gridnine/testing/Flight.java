package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = new ArrayList<>(Objects.requireNonNull(segments));
    }

    public List<Segment> getSegments() {
        return new ArrayList<>(segments);
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString).reduce((a, b) -> a + b).orElse("");
    }
}
