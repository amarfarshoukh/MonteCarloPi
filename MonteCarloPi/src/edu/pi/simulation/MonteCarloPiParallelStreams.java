package edu.pi.simulation;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MonteCarloPiParallelStreams {

    public static double estimatePi(int numPoints) {
        long insideCircle = IntStream.range(0, numPoints).parallel().filter(i -> {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();
            return x * x + y * y <= 1.0;
        }).count();

        return 4.0 * insideCircle / numPoints;
    }
}

