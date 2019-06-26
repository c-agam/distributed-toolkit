package com.czlt.reproduction.mgr.entity;

public class MpRole extends MpRoleKey {
    private Integer locked;

    private String description;

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}