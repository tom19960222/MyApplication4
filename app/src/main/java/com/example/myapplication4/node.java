package com.example.myapplication4;

import java.util.HashMap;
import java.util.Map;

public class node {
    private Integer Nid;
    private Integer Pid;
    private String Pname;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getNid() {
        return Nid;
    }


    public void setNid(Integer nid) {
        this.Nid = nid;
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        this.Pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        this.Pname = pname;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
