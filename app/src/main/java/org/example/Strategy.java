package org.example;

import java.util.List;

public interface Strategy {

  Needle run(List<Integer> requests);

  String getStrategyType();
}
