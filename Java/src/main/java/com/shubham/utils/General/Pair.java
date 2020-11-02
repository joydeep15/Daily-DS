package com.shubham.utils.General;

import java.util.ArrayList;
import java.util.List;

public class Pair<L,R> {

    private R r;
    private L l;
    public Pair(L l, R r) {
    	this.l=l;
    	this.r=r;
    }
    public L getL() {
    	return l;
    }
    public R getR() {
    	return r;
    }
    public void setL(L l) {
    	this.l=l;
    }
    public void setR(R r) {
    	this.r=r;
    }
}
