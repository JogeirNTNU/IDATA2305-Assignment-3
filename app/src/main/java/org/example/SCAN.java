package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * SCAN disc scheduling algorithm.
 */
public class SCAN {
  private List<Integer> requests = new ArrayList<>();

  /**
   * Constructor.
   */
  public SCAN(List<Integer> requests) {
    this.requests = requests;
  }

  public List<Integer> getRequests() {
    return this.requests;
  }

}
