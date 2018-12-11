package ru.sberbank.homework3;

public enum State {
    A, B, C, D, E;

    private static State[] values = values();

    public State nextState() {
        return values[(this.ordinal() + 1) % values.length];
    }
}
