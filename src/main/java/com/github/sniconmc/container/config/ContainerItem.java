package com.github.sniconmc.container.config;

public class ContainerItem {

    private int slot;
    private String id;
    private String container_id;
    private ContainerItemCount count;
    private ContainerItemDisplay display;
    private ContainerItemSkin skin;
    private ContainerItemData data;

    public String getContainerId() {
        return container_id;
    }

    public void setContainerId(String container_id) {
        this.container_id = container_id;
    }

    public int getSlot() {
        return slot;
    }

    public String getId() {
        return id;
    }

    public ContainerItemDisplay getDisplay() {
        return display;
    }

    public ContainerItemCount getCount() {
        return count;
    }

    public ContainerItemSkin getSkin() {
        if (skin == null) {
            return new ContainerItemSkin("", "", "");
        }
        return skin;
    }

    public ContainerItemData getData() {
        if (data == null) {
            return new ContainerItemData("","", true);
        }
        return data;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public void setCount(ContainerItemCount count) {
        this.count = count;
    }

    public void setDisplay(ContainerItemDisplay display) {
        this.display = display;
    }

    public void setSkin(ContainerItemSkin skin) {
        this.skin = skin;
    }

    public void setData(ContainerItemData data) {
        this.data = data;
    }
}
