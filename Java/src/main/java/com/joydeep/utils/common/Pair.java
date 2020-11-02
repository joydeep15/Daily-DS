package com.joydeep.utils.common;

public class Pair<L, M> {

    private L first;
    private M second;

    public Pair(L first, M second) {
        this.first = first;
        this.second = second;
    }

    public L getFirst() {return first;}
    public void setFirst(L first) {this.first = first;}

    public M getSecond() {return second;}
    public void setSecond(M second) {this.second = second;}

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
