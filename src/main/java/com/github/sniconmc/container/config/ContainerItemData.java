package com.github.sniconmc.container.config;

public class ContainerItemData {

    private String function;
    private String page;
    private Boolean isVanillaItem;

    public ContainerItemData(String function, String page, Boolean isVanillaItem) {
        this.function = function;
        this.page = page;
        this.isVanillaItem = isVanillaItem;
    }

    public String getFunction() {
        if (function == null) {
            return "";
        }
        return function;
    }

    public String getPage() {
        if (page == null){
            return "";
        }
        return page;
    }

    public Boolean isVanillaItem() {
        if (isVanillaItem == null) {
            return true;
        }
        return isVanillaItem;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setVanillaItem(Boolean vanillaItem) {
        isVanillaItem = vanillaItem;
    }
}
