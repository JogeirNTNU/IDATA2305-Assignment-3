package org.example;

public class Context {

  private Strategy currentStrategy;

  public Context(Strategy initialStrategy) {
    this.currentStrategy = initialStrategy;
  }

  /**
   * Set strategy later.
   */
  public Context() {
  }

  public void setStrategy(Strategy newStrat) {
    this.currentStrategy = newStrat;
  }

  public void executeStrategy() {
    this.currentStrategy.run();
  }
}
