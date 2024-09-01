package com.github.sniconmc.container.config;

import java.util.List;

public class ContainerInventorySettings {

    private int rows;
    private List<String> display_name;
    private String container_id;
    private boolean modify;
    private boolean modify_creative;

    public String getContainerID() {
        return container_id;
    }

    public List<String> getDisplayName() {
        return display_name;
    }

    public boolean isModify_creative() {
        return modify_creative;
    }

    public boolean isModify() {
        return modify;
    }

    public int getRow() {
        return rows;
    }
    public int getSize() {
        return rows * 9;
    }
}
