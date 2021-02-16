package ru.nook_of_madness.transport;

public class LandTransport extends Transport {
    private int restInterval;

    private int toRest;
    private int sleepTicks;


    public LandTransport(String name, int speed, int restInterval) {
        super(name, speed, TransportType.LAND);
        this.restInterval = restInterval;
        this.transportType = TransportType.LAND;
        this.toRest = restInterval;
    }

    protected int calculateRestDuration() {
        return 0;
    }

    @Override
    public void tick(TransportRaceState transportRaceState) {
        if (sleepTicks-- > 0) {
            return;
        }
        transportRaceState.setCurrentPosition(transportRaceState.getCurrentPosition() + speed);
        if (toRest-- <= 0) {
            sleepTicks = calculateRestDuration();
        }
    }
}
