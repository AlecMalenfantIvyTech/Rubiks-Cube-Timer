package sample;
import java.util.Random;

/**This class will create and track scrambles for a 3x3 rubik's cube  */

public class Scramble extends Cube {
    Random random = new Random();
    int num = random.nextInt(5);
    //default constructor
    Scramble (){
    }

    @Override
    public void createScramble(int length) {
        //put the current scramble into the new scramble and clear it out
        previousScramble = currentScramble;
        currentScramble = "";


        for (int i = 0; i<length; i++){
            currentScramble += createScramblePoint(random.nextInt(5), random.nextInt(2));
        }

    }




    @Override
    public String createScramblePoint(int faceNumber, int modNumber) {

        String[] faces = new String[6];
        faces[0] = "F";
        faces[1] = "B";
        faces[2] = "R";
        faces[3] = "L";
        faces[4] = "U";
        faces[5] = "D";

        //Modifications to the faces
        String[] mods = new String[3];
        mods[0] = "";
        mods[1] = "'";
        mods[2] = "2";

        //create the scramble point
        String scramblePoint = faces[faceNumber] + mods[modNumber] + " ";
        return scramblePoint;
    }


}
