package com.github.sniconmc.container.config;

public class ContainerItemSkin {
    private String player;
    private String uuid;
    private String texture;

    public ContainerItemSkin(String player, String uuid, String texture){
        this.player = player;
        this.uuid = uuid;
        this.texture = texture;
    }

    public String getPlayer() {
        return player;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTexture() {
        return texture;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
