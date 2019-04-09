package com.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造有向无环图
 */
public class GraphicConstuctor {

    public List<GraphicNode> nodes = null;

    private Integer[] weight = {1,2,2};

    public void initNodes(int n) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        GraphicNode node = null;
        for (int i=0; i<n; i++) {
            node = new GraphicNode(String.valueOf(i));
            node.setWeght(weight[i]);
            nodes.add(node);
        }
    }

    /*
    3个节点与权重: A(0)=1, B(1)=2, C(2)=2
    3条路径: A->B, B->C, A->C
    起点: A
     */
    public void initGraph(int n) {
        //初始化节点
        initNodes(n);
        //A->B
        GraphicEdge edge01 = new GraphicEdge(nodes.get(0), nodes.get(1));
        //A->C
        GraphicEdge edge02 = new GraphicEdge(nodes.get(0), nodes.get(2));
        //B->C
        GraphicEdge edge13 = new GraphicEdge(nodes.get(1), nodes.get(2));

        nodes.get(0).addEdge(edge01);
        nodes.get(0).addEdge(edge02);
        nodes.get(1).addEdge(edge13);
    }
}