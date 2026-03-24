package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * SCAN disc scheduling algorithm.
 */
public class SCAN implements Strategy {
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

  @Override
  public Needle run() {
    return new Needle(1,true); //:
  }

  @Override
  public String getAlgorithmName() {
    return "skibbidi toilet";
  }

}
