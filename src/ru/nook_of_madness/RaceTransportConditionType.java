package ru.nook_of_madness;

import ru.nook_of_madness.transport.FlightTransport;
import ru.nook_of_madness.transport.LandTransport;
import ru.nook_of_madness.transport.Transport;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public enum RaceTransportConditionType {
    LAND(transport -> transport instanceof LandTransport),
    FLIGHT(transport -> transport instanceof FlightTransport),
    ALL(transport -> transport instanceof LandTransport || transport instanceof FlightTransport);


    private Predicate<Transport> transportPredicate;
    RaceTransportConditionType(Predicate<Transport> predicate) {
        this.transportPredicate = predicate;
    }

    public boolean isAllowedTransport(Transport transport) {
        return transportPredicate.test(transport);
    }

}
