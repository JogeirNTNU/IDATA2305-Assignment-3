package org.example;

public class Context {

  Strategy currentStrategy;

  public Context(Strategy initialStrategy) {
    this.currentStrategy = initialStrategy;
  }

  /**
   * Set strategy later.
   */
  public Context() {
  }
}
