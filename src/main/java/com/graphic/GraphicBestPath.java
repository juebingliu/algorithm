package com.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * 最优路径
 */
public class GraphicBestPath {

    private int tempWeight = 1;//第一个节点的权重

    int maxWeight = 0;

    String result = "";

    private StringBuffer lsb = new StringBuffer();

    public String getResult() {
        return result;
    }

    public GraphicNode search(GraphicNode node, List<GraphicNode> visited) {

        // 如果已经查看过该节点，返回该节点
        if (visited.contains(node)) {
            return node;
        }
        //路径输出
        if(lsb.length() > 0){
            lsb.append("->");
        }

        lsb.append(node.getLabel());
        if(node.edgeList.size() > 0){
            //节点有邻边,则遍历
            for (int i=0; i<node.edgeList.size(); i++) {
                GraphicEdge edge = node.edgeList.get(i);
                int weight = edge.getTo().getWeght();
                tempWeight += weight;
                visited.add(node);
                //递归下一个节点
                GraphicNode next = search(edge.getTo(),visited);
                if(next.getLabel() != null && next.getLabel() != "") {
                    //减去退出路径的权重
                    tempWeight -= weight;
                    //删除退出路径的节点
                    if(lsb.length() <= 1){
                        lsb.delete(lsb.length()-1, lsb.length());
                    }else{
                        lsb.delete(lsb.length()-3, lsb.length());
                    }
                }
                //删除当前节点
                visited.remove(next);
            }
        }else{
            if(maxWeight < tempWeight){
                maxWeight = tempWeight;//更新最大权重
                //更新路径结果
                result = "（最优路径是："+lsb.toString()+",权重之和是："+maxWeight+"）";
            }
        }
        return node;
    }

    public static void main(String[] args) {
        GraphicConstuctor gc = new GraphicConstuctor();
        gc.initGraph(3);
        List<GraphicNode> visited = new ArrayList<>();
        GraphicBestPath gbp = new GraphicBestPath();
        gbp.search(gc.nodes.get(0),visited);
        System.out.println(gbp.getResult());
    }
}