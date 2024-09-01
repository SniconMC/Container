package com.github.sniconmc.container.config;

public class ContainerItemCount {

    private int current;
    private int max;

    public ContainerItemCount(int current, int max) {
        this.current = current;
        this.max = max;
    }

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
