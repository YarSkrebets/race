package ru.nook_of_madness.transport;

public class FlightTransport extends Transport {
    private double modifier = Double.NaN;

    public FlightTransport(String name, int speed) {
        super(name, speed);
    }

    public double calculateModifier(int distance) {
        return 1;
    }


    @Override
    public void tick(TransportRaceState transportRaceState) {
        if (Double.isNaN(modifier)) {
            //Загадка от Жака Фреско. На раздумие дается 30 секунд.
            modifier = 2 - calculateModifier(transportRaceState.getRace().getDistance());
        }
        transportRaceState.setCurrentPosition(transportRaceState.getCurrentPosition() + (speed * modifier));
    }
}
