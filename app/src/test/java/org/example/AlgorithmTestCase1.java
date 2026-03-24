package org.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlgorithmTestCase1 {

  private Needle needle;
  private List<Integer> requestsList;
  private Context context;

  @Before
  public void case1Init() {
    this.needle = new Needle(53, true);
    this.requestsList = Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);
    this.context = new Context();
  }


  @Test
  public void case1Scan() {

    this.needle.setRequests(requestsList);
    SCAN scan = new SCAN(this.needle);
    this.context.setStrategy(scan);
    Needle needle = context.executeStrategy();
    List<Integer> serviceOrder = Arrays.asList(53, 37, 14, 0, 65, 67, 98, 122, 124, 183);

    assertEquals("SCAN", scan.getAlgorithmName());
    assertEquals(serviceOrder, needle.getNeedlePath());
    assertEquals(236, needle.getTotalHeadMovement());
  }


  @Test
  public void case1SSTF() {
    this.needle.setRequests(requestsList);
    SSTF sstf = new SSTF(this.needle);
    this.context.setStrategy(sstf);
    Needle needle = context.executeStrategy();
    List<Integer> serviceOrder = Arrays.asList(53, 65, 67, 37, 14, 98, 122, 124, 183);

    assertEquals("Shortest seek time first", sstf.getAlgorithmName());
    assertEquals(serviceOrder, needle.getNeedlePath());
    assertEquals(236, needle.getTotalHeadMovement());
  }
}
