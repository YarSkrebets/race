package ru.nook_of_madness.transport;

public abstract class Transport {
    protected String name;
    protected int speed;

    public Transport(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public abstract void tick(TransportRaceState transportRaceState);
}
