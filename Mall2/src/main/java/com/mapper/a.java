package com.mapper;

import com.POJO.Node;
import com.POJO.Road;

import java.util.List;
import java.util.Map;

public interface a {
    List<Node> selectAllNode();
    List<Road> selectAllRoad();
    int addNode(Node node);
    int deletNode(int id);
    int addRoad(Road road);
    int deletRoad(int id);
}
