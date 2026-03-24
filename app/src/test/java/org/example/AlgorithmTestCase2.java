package org.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlgorithmTestCase2 {

  private Needle needle;
  private List<Integer> requestsList;
  private Context context;

  @Before
  public void case2Init() {
    this.needle = new Needle(50, true);
    this.requestsList = Arrays.asList(45, 48, 52, 90, 150, 160);
    this.context = new Context();
  }

  @Test
  public void case2SSTF() {
    this.needle.setRequests(requestsList);
    SSTF sstf = new SSTF(this.needle);
    this.context.setStrategy(sstf);
    Needle needle = context.executeStrategy();
    List<Integer> serviceOrder = Arrays.asList(50, 48, 45, 52, 90, 150, 160);

    assertEquals("Shortest seek time first", sstf.getAlgorithmName());
    assertEquals(serviceOrder, needle.getNeedlePath());
    assertEquals(120, needle.getTotalHeadMovement());
  }
}
