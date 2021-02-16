package ru.nook_of_madness;

import ru.nook_of_madness.transport.FlightTransport;
import ru.nook_of_madness.transport.Transport;
import ru.nook_of_madness.transport.Transports;

public class Main {

    public static void main(String[] args) {
        Race race = new Race(10000, RaceTransportConditionType.ALL);
        race.addTransport(Transports.BOOTS);
        race.addTransport(Transports.BROOM);
        race.addTransport(Transports.FLYING_CARPET);
        race.addTransport(Transports.TWO_HUMPED_CAMEL);
        race.addTransport(Transports.STUPA);
        race.addTransport(Transports.SCAR);
        race.runRace();
    }
}
