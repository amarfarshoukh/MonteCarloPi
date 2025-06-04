package edu.pi.simulation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MonteCarloPiTest {

    @Test
    public void testSequentialPi() {
        double pi = MonteCarloPiSequential.estimatePi(10_000_000);
        assertTrue(Math.abs(pi - Math.PI) < 0.01, "Sequential estimate not within tolerance");
    }

    @Test
    public void testParallelStreamPi() {
        double pi = MonteCarloPiParallelStreams.estimatePi(10_000_000);
        assertTrue(Math.abs(pi - Math.PI) < 0.01, "Parallel Stream estimate not within tolerance");
    }

    @Test
    public void testForkJoinPi() {
        double pi = MonteCarloPiForkJoin.estimatePi(10_000_000);
        assertTrue(Math.abs(pi - Math.PI) < 0.01, "Fork/Join estimate not within tolerance");
    }
}
