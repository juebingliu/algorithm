package com.netty.xml.dom4j;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author juebing
 * @date 2018/11/22 18:07
 * @description
 */
@XmlRootElement
public class Menu {
    private String name;
    private String id;
    private List<Menu> child;

    public Menu(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Menu() {
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}