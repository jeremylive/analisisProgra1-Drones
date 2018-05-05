package Libraries;

import Logic.Trip;
import java.util.ArrayList;

public class BacktrackingSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList,ArrayList<String> pHashKeys) {
        hashKeys = pHashKeys;  //1
        tripList = pTripList; //+1
        initializeMovementList(); //2+4N
        totalTime = System.currentTimeMillis(); //+1
        if (scheduleATrip(0)) { //+2 + 11 + 16N + 32N^2 + 6N^3
            System.out.println("All trips scheduled");
        } else {
            System.out.println("Error while scheduling trips");
        }
        totalTime = System.currentTimeMillis() - totalTime; //+2
        printResult(); //+1
    }
    //1+1+2+4N+1+2+11+16N+31N^2+6N^3+2+1 = 21+20N+31N^2+6N^3
    
    //O(N) = O(N^3)

    private boolean scheduleATrip(int pCurrentTrip) {
        //Stop condition : All trips scheduled.
        if (pCurrentTrip == tripList.size()) { //+1
            return true; //+1
        }
        //Gets the current Trip object and its possible spaces.
        Trip currentTrip = tripList.get(pCurrentTrip); //+2
        ArrayList<Integer> possibleSpaces = getPossibleSpaces(currentTrip); //2+11+16N+31N^2+6N^3
        //Consider each possible space
        for (int chosenSpace : possibleSpaces) { //+1(+3
            //Make tentative placement.
            insertTrip(currentTrip, chosenSpace); //+2 + N
            //Schedules the next trip.
            if (scheduleATrip(pCurrentTrip + 1)) { //+1
                return true; //+1
            }
            //A trip after this one failed, undo the placement and try again.
            removeTrip(currentTrip, chosenSpace); //+2 +N
        }
        return false; //+1
    }

}//1+1+2+2+3+11N+28N^2+6N^3+1(3+3+N+1+1+2+N)*N +1 = 11 + 16N + 31N^2 + 6N^3
