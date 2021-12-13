package sample;
import java.util.Random;

//this will be the general class for every type of rubik's cube. A standard 3x3 rubik's cube will be the default.
public abstract class Cube {
    String currentScramble = "";
    String previousScramble = "";
    int numOfSides = 6;
    int dimensionOne = 3;
    int dimensionTwo = 3;



    public abstract void createScramble(int length);


    public abstract String createScramblePoint(int faceNumber, int modNumber);


    ;
}
