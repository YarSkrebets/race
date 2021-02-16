package ru.nook_of_madness.transport;

public abstract class Transport {
    protected String name;
    protected int speed;
    protected TransportType transportType;

    public Transport(String name, int speed, TransportType transportType) {
        this.name = name;
        this.speed = speed;
        this.transportType = transportType;
    }

    public String getName() {
        return name;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public abstract void tick(TransportRaceState transportRaceState);
}
