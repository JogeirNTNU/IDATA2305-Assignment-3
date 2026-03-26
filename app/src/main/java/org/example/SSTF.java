package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * SSTF - Shortest Seek Time First
 * Algorithm that handles a list of requests using SSTF algorithm
 * This algorithm handles requests in the order of which is closest to the
 * needle position after each handled request first.
 */
public class SSTF implements Strategy {

  private final String algoName = "Shortest seek time first";
  private Needle needle;

  /**
   * Constructor for the SSTF - Shortest Seek Time First algorithm
   * 
   * @param needle the needle which holds list of requests and current position
   */
  public SSTF(Needle needle) {
    this.needle = needle;
  }

  /**
   * Returns the name of the algorithm
   */
  public String getAlgorithmName() {
    return this.algoName;
  }

  /**
   * Run method
   * Performs the operation on the list of requests using SSTF algorithm.
   * Finds the closest request to the needle and moves the needle to said location
   * 
   * @return the needle which holds needle path and totalHeadMovement
   */
  public Needle run() {
    boolean finished = false;
    this.needle.addPathToNeedlePath(this.needle.getCurrentPosition());
    while (!finished) {
      int request = findLeastDeltaNumber();

      this.needle.addTotalHeadMovement(
          Math.abs(request - this.needle.getCurrentPosition()));
      this.needle.addPathToNeedlePath(request);

      this.needle.setCurrentPosition(request);

      if (this.needle.getRequests().isEmpty()) {
        finished = true;
      }
    }
    new PrintResults(this.needle, this.algoName);
    return this.needle;
  }

  /**
   * Finds the request which is closest to the needle's position
   * @return the position of the request which is closest to the needle's position
   */
  private int findLeastDeltaNumber() {
    int shortestRequest = this.needle.getRequests().getFirst();

    for (int i : this.needle.getRequests()) {
      if (Math.abs(this.needle.getCurrentPosition() - i) < Math
          .abs(this.needle.getCurrentPosition() - shortestRequest)) {
        shortestRequest = i;
      }
    }
    removeRequestFromRequests(shortestRequest);
    return shortestRequest;
  }

  /**
   * Removes a request from the needle's list of requests
   * 
   * @param request the position of the request
   */
  private void removeRequestFromRequests(int request) {

    List<Integer> requests = new ArrayList<>(this.needle.getRequests());
    requests.removeIf(r -> r == request);
    this.needle.setRequests(requests);
  }
}
