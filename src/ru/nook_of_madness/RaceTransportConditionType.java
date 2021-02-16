package ru.nook_of_madness;

import ru.nook_of_madness.transport.TransportType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum RaceTransportConditionType {
    LAND(TransportType.LAND), FLIGHT(TransportType.FLIGHT), ALL(TransportType.LAND, TransportType.FLIGHT);

    private Set<TransportType> availableTransportType;

    RaceTransportConditionType(TransportType... availableTransportType) {
        this.availableTransportType = new HashSet<>();
        this.availableTransportType.addAll(Arrays.asList(availableTransportType));
    }

    public Set<TransportType> getAvailableTransportType() {
        return availableTransportType;
    }

    public boolean isAllowedTransport(TransportType transportType) {
        return availableTransportType.contains(transportType);
    }
}
