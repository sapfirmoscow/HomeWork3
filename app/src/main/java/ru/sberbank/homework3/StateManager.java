package ru.sberbank.homework3;

public class StateManager {
    private static final StateManager instanse;

    static {
        instanse = new StateManager();
    }

    private State state;

    public StateManager() {
        state = State.A;
    }

    public static StateManager getInstanse() {
        return instanse;
    }

    public State getState() {
        return state;
    }

    public void updateState() {
        state = state.nextState();
    }
}
