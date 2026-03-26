package org.example;

import java.util.List;

/**
 * All algorithms should implement this interace.
 */
public interface Strategy {

  Needle run();

  String getAlgorithmName();
}
