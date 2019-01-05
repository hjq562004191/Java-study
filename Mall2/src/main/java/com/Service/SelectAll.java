package com.Service;

import com.POJO.Node;
import com.POJO.Road;

import java.io.IOException;
import java.util.List;


public interface SelectAll {
    List<Node> selectAllNode() throws IOException;
    List<Road> selectAllRoad() throws IOException;
    int addNode(Node node) throws IOException;
    int deletNode(int id) throws IOException;
    int addRoad(Road road) throws IOException;
    int deletRoad(int id) throws IOException;
}
