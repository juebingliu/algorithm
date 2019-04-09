package com.graphic;

/**
 * 边
 */
public class GraphicEdge {

    private GraphicNode from;

    private GraphicNode to;



    public GraphicEdge(GraphicNode from, GraphicNode to) {
        this.from = from;
        this.to = to;
    }

    public GraphicNode getFrom() {
        return from;
    }

    public GraphicNode getTo() {
        return to;
    }
}