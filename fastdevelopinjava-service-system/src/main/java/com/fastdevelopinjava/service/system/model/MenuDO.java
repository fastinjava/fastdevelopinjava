package com.fastdevelopinjava.service.system.model;

import java.util.Date;

public class MenuDO {
    /**
     * menu id
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 父菜单id，如果menu_type=-1，代表当前父菜单id为客户端id
     */
    private String menuPid;

    /**
     * 菜单类型,
     * <p>
     * -1->客户端
     * <p>
     * 0->目录 1->页面路由 2->按钮
     */
    private String menuType;

    /**
     * 如果是按钮类型,按钮是否可见
     */
    private String menuVisible;

    /**
     * 如果是按钮类型,按钮关联的接口
     */
    private String menuApiIds;

    /**
     * 是否删除
     */
    private String deleteFlag;

    private Date createTime;

    private Date updateTime;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuVisible() {
        return menuVisible;
    }

    public void setMenuVisible(String menuVisible) {
        this.menuVisible = menuVisible;
    }

    public String getMenuApiIds() {
        return menuApiIds;
    }

    public void setMenuApiIds(String menuApiIds) {
        this.menuApiIds = menuApiIds;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}