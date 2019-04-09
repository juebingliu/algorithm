package com.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点
 */
public class GraphicNode {

    public List<GraphicEdge> edgeList = null;

    private String label = "";

    private int weght;

    public GraphicNode(String label) {
        this.label = label;
        if(edgeList == null) {
            edgeList = new ArrayList<>();
        }
    }

    public void addEdge(GraphicEdge edge) {
        edgeList.add(edge);
    }

    public String getLabel() {
        return label;
    }

    public int getWeght() {
        return weght;
    }

    public void setWeght(int weght) {
        this.weght = weght;
    }
}