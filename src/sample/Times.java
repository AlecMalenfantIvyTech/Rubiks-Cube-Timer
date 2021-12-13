//This class will track all of the times for the program and calculate the averages

package sample;

import java.util.ArrayList;
import java.util.List;

public class Times {
    List<Integer> timesList = new ArrayList<>(); 

    int averageOfFive = 0;
    int averageOfTen = 0;

//no arg constructor
    Times(){
    }

//Methods
    void addTime(int time){
        timesList.add(time);
    }

    void removeTime(int time){
        timesList.remove(1);
    }

    int calcAvgOfFive(){
        int total = 0;
        int i = 1;
        if (timesList.size()<5){
            total= 0;
        }
        //get total of the 5 integers
        else{
            while (i < 6){
                total += timesList.get(timesList.size()-i);
                i++;
            }

        }
        averageOfFive = total / 5;
        return averageOfFive;
    }

    int calcAvgOfTen(){
        int total = 0;
        int i = 1;
        if (timesList.size()<10){
            total= 0;
        }
        //get total of the 5 integers
        else{
            while (i < 11){
                total += timesList.get(timesList.size()-i);
                i++;
            }

        }
        averageOfTen = total / 5;
        return averageOfTen;
    }
}
