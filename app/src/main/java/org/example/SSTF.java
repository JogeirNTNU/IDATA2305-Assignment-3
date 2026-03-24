package org.example;

import java.util.ArrayList;
import java.util.List;

public class SSTF implements Strategy {

  private final String algoName = "Shortest seek time first";
  private Needle needle;

  public SSTF(Needle needle) {
    this.needle = needle;
  }

  public String getAlgorithmName() {
    return this.algoName;
  }

  public Needle run() {
    boolean finished = false;
    this.needle.addPathToNeedlePath(this.needle.getCurrentPosition());
    while (!finished) {
      int request = findLeastDeltaNumber();

      this.needle.addTotalHeadMovement(
        Math.abs(request-this.needle.getCurrentPosition())
      );
      this.needle.addPathToNeedlePath(request);

      this.needle.setCurrentPosition(request);

      if (this.needle.getRequests().isEmpty()) {
        finished = true;
      }
    }
    new printResults(this.needle, this.algoName);
    return this.needle;
  }

  private int findLeastDeltaNumber() {
    int shortestRequest = this.needle.getRequests().getFirst();

    for (int i : this.needle.getRequests()) {
      if (
        Math.abs(this.needle.getCurrentPosition() - i) <
        Math.abs(this.needle.getCurrentPosition() - shortestRequest)
        ) {
        shortestRequest = i;
      }
    }
    removeRequestFromRequests(shortestRequest);
    return shortestRequest;
  }

  private void removeRequestFromRequests(int request) {
    
    List<Integer> requests = new ArrayList<>(this.needle.getRequests());
    requests.removeIf(r -> r == request);
    this.needle.setRequests(requests);
  }
}
