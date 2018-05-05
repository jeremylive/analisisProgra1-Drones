package Libraries;

import Logic.Trip;
import java.util.ArrayList;
import java.util.Random;

public class ProbabilisticSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList, ArrayList<String> pHashKeys) {
        hashKeys = pHashKeys; //+1
        tripList = pTripList; //+1
        initializeMovementList(); //2N+4
        boolean success = true;//+1
        totalTime = System.currentTimeMillis(); //+1
        for (Trip currentTrip : pTripList) { //+1(+3
            if (!scheduleATrip(currentTrip)) { //1++(14+11N+28N^2+6N^3)
                success = false;  //+1
                break;
            } //)*N
        }      
        
        totalTime = System.currentTimeMillis() - totalTime; //+2
        if (success) { //+1
            System.out.println("All trips scheduled");
        } else {
            System.out.println("Error while scheduling trip");
        }
        printResult();//+1
    }

    //1+1+2+4N +1+1+1+(3+1+14+11N+28N^2+6N^3+1)*N +2 +1+1+1 = 11+21N+11n^2+28n^3+6N^4
    //O(N) = O(N^4)
    
    private boolean scheduleATrip(Trip pTrip) {
        Random numberGenerator = new Random(); //+1
        ArrayList<Integer> possibleSpaces = getPossibleSpaces(pTrip); //+2(3+11N+28N^2+6N^3
        if (possibleSpaces.isEmpty()) { //+1
            return false;//+1
        }
        int chosenSpace = numberGenerator.nextInt(possibleSpaces.size());//+2
        insertTrip(pTrip, possibleSpaces.get(chosenSpace));//+3
        return true;//+1
    }
}
//1+2+3+11N+28N^2+6N^3+1+1+2+2+2 = 14+11N+ 28^2 +6N^3