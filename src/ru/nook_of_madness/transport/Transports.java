package ru.nook_of_madness.transport;

public interface Transports {
    Transport TWO_HUMPED_CAMEL = new LandTransport("Двугорбый верблюд", 10, 30) {
        int time = 0;
        @Override
        protected int calculateRestDuration() {
            time++;
            if (time == 1) {
                return 5;
            } else return 8;
        }
    };

    Transport FAST_CAMEL = new LandTransport("Верблюд-быстроход", 40, 10) {
        int time = 0;
        @Override
        protected int calculateRestDuration() {
            time++;
            if (time == 1) {
                return 5;
            } else if (time == 2) {
                return 6;
            } else return 8;
        }
    };

    Transport CENTAUR = new LandTransport("Кентавр", 15, 8) {
        @Override
        protected int calculateRestDuration() {
            return 2;
        }
    };

    Transport BOOTS = new LandTransport("Ботинки быстрые такие", 6, 60) {
        int time = 0;
        @Override
        protected int calculateRestDuration() {
            time++;
            if (time == 1) {
                return 10;
            } else return 5;
        }
    };

    Transport FLYING_CARPET = new FlightTransport("Ковер-Самолет", 10) {
        @Override
        public double calculateModifier(int distance) {
            if (distance < 1000) {
                return 1;
            }
            if (distance < 5000) {
                return 0.97;
            }

            if (distance < 10000) {
                return 0.9;
            }
            return 0.95;
        }
    };

    Transport STUPA = new FlightTransport("Ступа", 10) {
        @Override
        public double calculateModifier(int distance) {
            return 0.94;
        }
    };

    Transport BROOM = new FlightTransport("Метла", 20) {
        @SuppressWarnings("IntegerDivisionInFloatingPointContext")
        @Override
        public double calculateModifier(int distance) {
            return 1 - ((distance / 1000) * 0.1);
        }
    };


    Transport SCAR = new FlightTransport("Тебя даблтапнуть в один тик?", 100000) {
        @Override
        public double calculateModifier(int distance) {
            return 1;
        }
    };
}
