package org.example;

/**
 * FCFS disk scheduling strategy.
 *
 * <p>Requests are processed strictly in the order they appear in
 * {@link Needle#getRequests()}. For each request, head movement is calculated
 * as the absolute distance from the current head position to the request.
 *
 * <p>This strategy mutates the provided {@link Needle} instance by updating the
 * current position, total head movement, and the recorded needle path.
 */

public class FCFS implements Strategy {

    private final String algoName = "First Come First Serve";
    private Needle needle;

    /**
     * Creates an FCFS strategy operating on the given needle state.
     * @param needle the needle state and request queue used by this strategy
     */

    public FCFS(Needle needle) {
        this.needle = needle;
    }

    /**
     * Executes FCFS scheduling.
     *
     * <p>The method starts by adding the current position to the needle path,
     * then processes each request in insertion order. After completion, results
     * are printed via {@link PrintResults}.
     *
     * @return the same {@link Needle} instance after applying FCFS
     */
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

    /**
     * Returns the name of this scheduling algorithm.
     *
     * @return algorithm name
     */
    @Override
    public String getAlgorithmName() {
        return algoName;
    }
}
