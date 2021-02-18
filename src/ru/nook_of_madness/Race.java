package ru.nook_of_madness;

import ru.nook_of_madness.transport.Transport;
import ru.nook_of_madness.transport.TransportRaceState;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private int distance;
    private List<Transport> transportList = new ArrayList<>();
    private RaceTransportConditionType raceTransportConditionType;

    public Race(int distance, RaceTransportConditionType raceTransportConditionType) {
        this.distance = distance;
        this.raceTransportConditionType = raceTransportConditionType;
    }

    public void addTransport(Transport transport) {
        if (raceTransportConditionType.isAllowedTransport(transport)) {
            transportList.add(transport);
        } else {
            throw new RuntimeException(transport + " is not allowed in race typed " + raceTransportConditionType.name());
        }
    }

    public void runRace() {
        List<TransportRaceState> transportStates = new ArrayList<>();

        for (Transport tr : transportList) {
            transportStates.add(new TransportRaceState(tr, this));
        }
        System.out.println("Гонка начинается!");
        int ticks = 0;
        while (transportStates.stream().anyMatch(transportRaceState -> transportRaceState.getFinishTick() == -1)) {
            ticks++;
            for (TransportRaceState transportRaceState : transportStates) {
                if (transportRaceState.getFinishTick() == -1) {
                    transportRaceState.getTransport().tick(transportRaceState);
                    if (transportRaceState.getCurrentPosition() >= distance) {
                        transportRaceState.setFinishTick(ticks);
                        System.out.println(transportRaceState.getTransport().getName() + " пришел к финишу к " + ticks + " тику.");
                    }
                }
            }
        }

        System.out.println("Гонка завершена! Tick: " + ticks);
        transportStates.sort(Comparator.comparingInt(TransportRaceState::getFinishTick));
        for (int i = 0; i < transportStates.size(); i++) {
            TransportRaceState transportState = transportStates.get(i);
            System.out.println((i + 1) + ". " + transportState.getTransport().getName() + " : " + transportState.getFinishTick());
        }
    }

    public int getDistance() {
        return distance;
    }
}
