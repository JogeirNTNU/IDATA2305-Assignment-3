package org.example;

import java.util.ArrayList;
import java.util.List;

public class Needle {

  private List<Integer> needlePath = new ArrayList<>();
  private int totalHeadMovement = 0;
  private int startPos;
  private List<Integer> requests;
  private boolean clockwisePath;
  private int currentPosition;

  public Needle(int startPos, boolean clockwisePath) {
    this.startPos = startPos;
    this.currentPosition = startPos;
  }

  public List<Integer> getRequests() {
    return this.requests;
  }

  public void setClockwisePath(boolean clockwisePath) {
    this.clockwisePath = clockwisePath;
  }

  public boolean isClockwisePath() {
    return this.clockwisePath;
  }

  public void setRequests(List<Integer> requests) {
    this.requests = requests;
  }

  public int getStartPos() {
    return this.startPos;
  }

  public void setStartPos(int startPos) {
    this.startPos = startPos;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }

  public List<Integer> getNeedlePath() {
    return this.needlePath;
  }

  public int getTotalHeadMovement() {
    return this.totalHeadMovement;
  }
}
