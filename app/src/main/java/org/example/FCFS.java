package org.example;

public class FCFS implements Strategy {

    private final String algoName = "First Come First Serve";
    private Needle needle;

    public FCFS(Needle needle) {
        this.needle = needle;
    }

    @Override
    public Needle run() {
        needle.addPathToNeedlePath(needle.getCurrentPosition());
        for (int request : needle.getRequests()) {
            int movement = Math.abs(request - needle.getCurrentPosition());
            needle.addTotalHeadMovement(movement);

            needle.setCurrentPosition(request);
            needle.addPathToNeedlePath(request);
        }

        new PrintResults(needle, algoName);
        return needle;
    }

    @Override
    public String getAlgorithmName() {
        return algoName;
    }
}