package org.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlgorithmTestCase3 {

  private Needle needle;
  private List<Integer> requestsList;
  private Context context;

  @Before
  public void case3Init() {
    this.needle = new Needle(15, true);
    this.requestsList = Arrays.asList(10, 12, 14, 16, 100, 102);
    this.context = new Context();
  }

  @Test
  public void case3SSTF() {
    this.needle.setRequests(requestsList);
    SSTF sstf = new SSTF(this.needle);
    this.context.setStrategy(sstf);
    Needle needle = context.executeStrategy();
    List<Integer> serviceOrder = Arrays.asList(15, 14, 12, 10, 16, 100, 102);

    assertEquals("Shortest seek time first", sstf.getAlgorithmName());
    assertEquals(serviceOrder, needle.getNeedlePath());
    assertEquals(97, needle.getTotalHeadMovement());
  }

}
