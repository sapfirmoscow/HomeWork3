package ru.sberbank.homework3;

public class StateManager {
    private static final StateManager instanse;
    private State state;

    public StateManager() {
        state = State.A;
    }

    public static StateManager getInstanse() {
        return instanse;
    }

    static {
        instanse = new StateManager();
    }

    public State getState() {
        return state;
    }

    public void updateState() {
        state = state.nextState();
    }
}
