package com.czlt.reproduction.mgr.entity;

public class MpMenu {
    private Integer menuid;

    private Integer menufid;

    private String menuname;

    private String menuurl;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getMenufid() {
        return menufid;
    }

    public void setMenufid(Integer menufid) {
        this.menufid = menufid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }
}