package edu.pi.simulation;

import java.util.Random;

public class MonteCarloPiSequential {

    public static double estimatePi(int numPoints) {
        Random rand = new Random(42); // Fixed seed for reproducibility
        int insideCircle = 0;

        for (int i = 0; i < numPoints; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }

        return 4.0 * insideCircle / numPoints;
    }
}
