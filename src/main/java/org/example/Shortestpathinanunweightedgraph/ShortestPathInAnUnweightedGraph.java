package org.example.Shortestpathinanunweightedgraph;

import java.util.LinkedList;

public class ShortestPathInAnUnweightedGraph {


    /*
    Problem statement
The city of Ninjaland is analogous to the unweighted graph. The city has ‘N’ houses numbered from 1 to ‘N’ respectively and are connected by M bidirectional roads. If a road is connecting two houses ‘X’ and ‘Y’ which means you can go from ‘X’ to ‘Y’ or ‘Y’ to ‘X’. It is guaranteed that you can reach any house from any other house via some combination of roads. Two houses are directly connected by at max one road.

A path between house ‘S’ to house ‘T’ is defined as a sequence of vertices from ‘S’ to ‘T’. Where starting house is ‘S’ and the ending house is ‘T’ and there is a road connecting two consecutive houses. Basically, the path looks like this: (S , h1 , h2 , h3 , ... T). you have to find the shortest path from ‘S’ to ‘T’.

For example
In the below map of Ninjaland let say you want to go from S=1 to T=8, the shortest path is (1, 3, 8). You can also go from S=1 to T=8  via (1, 2, 5, 8)  or (1, 4, 6, 7, 8) but these paths are not shortest.



    * https://www.codingninjas.com/studio/problems/shortest-path-in-an-unweighted-graph_981297?topList=top-microsoft-coding-interview-questions&problemListRedirection=true&leftPanelTabValue=PROBLEM&customSource=studio_nav
    * */

    public static LinkedList<Integer> shortestPath(
            int[][] edges,
            int n,
            int m,
            int s,
            int t) {

        LinkedList<LinkedList<Integer>> paths = new LinkedList<>();
        searchPaths(paths, new LinkedList<>(), s, t, edges);

        LinkedList<Integer> shortestPath = new LinkedList<>();
        int shortestPathSize = Integer.MAX_VALUE;
        for(LinkedList<Integer> path : paths){
            if(path.size() < shortestPathSize){
                shortestPath = path;
                shortestPathSize = path.size();
            }
        }
        return shortestPath;
    }

    public static void searchPaths(
            LinkedList<LinkedList<Integer>> paths ,
            LinkedList<Integer> currentPath,
            int currentPosition,
            int target,
            int[][] edges ){
        if(  !currentPath.contains( Integer.valueOf(currentPosition))  ){

            if(currentPosition == target){
                currentPath.add(Integer.valueOf(currentPosition));
                paths.add(currentPath);
            }else{
                for(int i = 0; i<edges.length ; i++){
                    if(edges[i][0] == currentPosition){
                        LinkedList<Integer> copyOfCurrentPath = (LinkedList<Integer>) currentPath.clone();
                        copyOfCurrentPath.add(currentPosition);
                        searchPaths(paths, copyOfCurrentPath , edges[i][1] , target, edges);
                    }
                }
            }
        }
    }

}
