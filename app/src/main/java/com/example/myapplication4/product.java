package com.example.myapplication4;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.apache.commons.lang3.builder.ToStringBuilder;

public class product {

    private Integer Pid;
    private String Pname;
    private String description;
    private List<String> image = null;
    private Array ProductName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Array getProductName() {
        return ProductName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("pid", pid).append("pname", pname).append("description", description).append("image", image).append("additionalProperties", additionalProperties).toString();
//    }

}
