package com.czlt.reproduction.mgr.entity;

public class MpRole {
    private Integer roleno;

    private String rolename;

    private Integer locked;

    private String description;

    public Integer getRoleno() {
        return roleno;
    }

    public void setRoleno(Integer roleno) {
        this.roleno = roleno;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

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