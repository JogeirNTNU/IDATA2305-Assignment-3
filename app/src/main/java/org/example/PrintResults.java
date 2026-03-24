package org.example;

import java.util.List;

public class PrintResults {

  public PrintResults(Needle needle, String algoName){

    List<Integer> path = needle.getNeedlePath();

    StringBuilder strPath = new StringBuilder();
    for (int i : path) { //Adds path to strPath
        strPath.append(i).append(" -> ");
    }
    
    // Remove trailing " -> "
    if (strPath.length() > 0) {
        strPath.setLength(strPath.length() - 4);
    }
    double numberOfRequests = (double) needle.getNeedlePath().size()-1; //cast size to double
    double averageSeekDistance = needle.getTotalHeadMovement()/numberOfRequests;

    System.out.println(
      "=============================================\n" +

      "Algorithm: " + algoName + "\n" +

      "Service order: " + strPath + "\n" +
      
      "Total head movement: " + needle.getTotalHeadMovement() + "\n" +

      "Average seek distance: " + averageSeekDistance + "\n" +

      "============================================="
    );

  }
}
