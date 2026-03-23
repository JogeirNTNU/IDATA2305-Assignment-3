package org.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlgorithmTestCase1 {

  @Before
  public void case1Init() {
    /*
     * Initial Head Position: 53
     * Initial Direction: right
     * Requests:
     * 98, 183, 37, 122, 14, 124, 65, 67
     */
    Needle needle = new Needle(53, true);
    List<Integer> requestsList = new ArrayList<>();
    SCAN scan = new SCAN(requestsList);
    Context context = new Context(scan);
    context.executeStrategy();
  }
}
