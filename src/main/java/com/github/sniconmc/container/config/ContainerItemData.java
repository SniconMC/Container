package com.github.sniconmc.container.config;

public class ContainerItemData {

    private String function;
    private String page;
    private Boolean is_vanilla_item;

    public ContainerItemData(String function, String page, Boolean is_vanilla_item) {
        this.function = function;
        this.page = page;
        this.is_vanilla_item = is_vanilla_item;
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
        if (is_vanilla_item == null) {
            return false;
        }
        return is_vanilla_item;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setVanillaItem(Boolean vanillaItem) {
        is_vanilla_item = vanillaItem;
    }
}
