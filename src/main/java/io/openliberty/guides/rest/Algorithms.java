package io.openliberty.guides.rest;
import java.util.List;



public class Algorithms {
    static double CalcAvgCost(List<Double> cost){
        double add=0;
        int count=0;
        for (int i = 0; i < cost.size();i++){
            add += cost.get(i);
            count++;
        }
        return add/count;
    }

    static double CalculateCost(int views,int time){
        double stime = (double)time / 1000;
        double cost = (double)views + stime;
        return cost;
    }

    //neni treba ale necham ho tu
    static List<Double> BubbleSort(List<Double> list){
        
        for (int i = 0;i<list.size()-1;i++) {
            for (int j = 0;j<list.size()-1;j++) {
                if (list.get(j)>list.get(j+1)) {
                    double pom = list.get(j+1);
                    list.set(j+1,list.get(j));
                    list.set(j,pom);

                }
            }
        }
        return list;
        
    }
    
}
