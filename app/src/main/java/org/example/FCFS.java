package org.example;

public class FCFS implements Strategy {

  @Override
  public Needle run() {
    return new Needle(1,true); //:
  }

  @Override
  public String getAlgorithmName() {
    return "skibbidi toilet";
  }
}
