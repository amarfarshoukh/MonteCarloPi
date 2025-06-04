package edu.pi.simulation;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloPiForkJoin {

    static class PiTask extends RecursiveTask<Long> {
        private final int start, end;
        private static final int THRESHOLD = 100_000;

        public PiTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long count = 0;
                for (int i = start; i < end; i++) {
                    double x = ThreadLocalRandom.current().nextDouble();
                    double y = ThreadLocalRandom.current().nextDouble();
                    if (x * x + y * y <= 1.0) {
                        count++;
                    }
                }
                return count;
            } else {
                int mid = (start + end) / 2;
                PiTask left = new PiTask(start, mid);
                PiTask right = new PiTask(mid, end);
                left.fork();
                return right.compute() + left.join();
            }
        }
    }

    public static double estimatePi(int numPoints) {
    try (ForkJoinPool pool = new ForkJoinPool()) {
        long insideCircle = pool.invoke(new PiTask(0, numPoints));
        return 4.0 * insideCircle / numPoints;
    }
}

}


