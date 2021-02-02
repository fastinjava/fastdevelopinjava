package com.fastdevelopinjava.framework.ucenter.common.res;

import java.io.Serializable;
import java.util.List;

public class NodeDTO implements Serializable {
    private String id;
    private String pid;
    private String label;
    private List<NodeDTO> children;

    public NodeDTO() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<NodeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<NodeDTO> children) {
        this.children = children;
    }
}
