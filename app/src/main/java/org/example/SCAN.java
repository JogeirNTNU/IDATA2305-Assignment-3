package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.example.Needle;

/**
 * SCAN disc scheduling algorithm.
 */
public class SCAN implements Strategy {
  private final Needle needle;

  /**
   * Constructor.
   */
  public SCAN(Needle needle) {
    this.needle = needle;

  }

  /**
   * Responsible for running the simulation, for this algorithm.
   *
   * @returns The needle that holds all values which is used to test the
   *          algorithm.
   */
  @Override
  public Needle run() {

    List<Integer> clockWise = new ArrayList<>();
    List<Integer> antiClockWise = new ArrayList<>();

    for (int i : needle.getRequests()) {
      if (i < needle.getStartPos()) {
        clockWise.add(i);
      } else {
        antiClockWise.add(i);
      }
    }

    clockWise.sort(Comparator.reverseOrder());
    antiClockWise.sort(Comparator.naturalOrder());

    needle.addPathToNeedlePath(needle.getStartPos());
    boolean isFinished = false;
    while (!isFinished) {
      if (needle.isClockwisePath()) {

        for (int i : clockWise) {

          needle.addPathToNeedlePath(i);
          needle.addTotalHeadMovement(Math.abs(i - needle.getCurrentPosition()));
          needle.setCurrentPosition(i);
        }
        needle.addPathToNeedlePath(0);
        needle.addTotalHeadMovement(needle.getCurrentPosition());
        needle.setCurrentPosition(0);

        for (int i : antiClockWise) {

          needle.addPathToNeedlePath(i);
          needle.addTotalHeadMovement(Math.abs(i - needle.getCurrentPosition()));
          needle.setCurrentPosition(i);

        }
        isFinished = true;

      } else {
        for (int i : antiClockWise) {

          needle.addPathToNeedlePath(i);
          needle.addTotalHeadMovement(Math.abs(antiClockWise.get(i) - needle.getCurrentPosition()));
          needle.setCurrentPosition(i);

        }
        for (int i : clockWise) {

          needle.addPathToNeedlePath(i);
          needle.addTotalHeadMovement(Math.abs(needle.getStartPos() - needle.getCurrentPosition()));
          needle.setCurrentPosition(i);
        }
        isFinished = true;
      }

    }

    new PrintResults(needle, getAlgorithmName());
    return needle;
  }

  @Override
  public String getAlgorithmName() {
    return "SCAN";
  }
}
