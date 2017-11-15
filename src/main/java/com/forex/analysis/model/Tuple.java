package com.forex.analysis.model;

public class Tuple<A, B> {

    private final A a;

    private final B b;

    public Tuple(final A a, final B b) {
        super();
        this.a = a;
        this.b = b;
    }

    public final A getA() {
        return this.a;
    }

    public final B getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return "Tuple [a=" + this.a + ", b=" + this.b + "]";
    };

}
