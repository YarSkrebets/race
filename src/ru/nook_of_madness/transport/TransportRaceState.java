package ru.nook_of_madness.transport;

import ru.nook_of_madness.Race;

public class TransportRaceState {
    private Transport transport;
    private Race race;
    private double currentPosition = 0;
    private int finishTick = -1;

    public TransportRaceState(Transport transport, Race race) {
        this.transport = transport;
        this.race = race;
    }

    public double getCurrentPosition() {
        return currentPosition;
    }

    public int getFinishTick() {
        return finishTick;
    }

    public Transport getTransport() {
        return transport;
    }

    public Race getRace() {
        return race;
    }

    public void setCurrentPosition(double currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setFinishTick(int finishTick) {
        this.finishTick = finishTick;
    }
}
