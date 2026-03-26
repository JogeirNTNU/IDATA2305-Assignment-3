package org.example;

public class Context {

  private Strategy currentStrategy;

  public Context(Strategy initialStrategy) {
    this.currentStrategy = initialStrategy;
  }

  /**
   * Context class, used to switch between algorithms (Strategies), and execute
   * them easily.
   */
  public Context() {
  }

  public void setStrategy(Strategy newStrat) {
    this.currentStrategy = newStrat;
  }

  public Needle executeStrategy() {
    return this.currentStrategy.run();
  }
}
