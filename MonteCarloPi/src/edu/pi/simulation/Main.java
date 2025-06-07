package edu.pi.simulation;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10_000_000, 50_000_000, 100_000_000};

        System.out.println("Method,N,PiEstimate,TimeMs");

        for (int N : sizes) {
            long start, duration;

            start = System.nanoTime();
            double piSeq = MonteCarloPiSequential.estimatePi(N);
            duration = System.nanoTime() - start;
            System.out.printf("Sequential,%d,%.6f,%.2f%n", N, piSeq, duration / 1e6);

            start = System.nanoTime();
            double piStream = MonteCarloPiParallelStreams.estimatePi(N);
            duration = System.nanoTime() - start;
            System.out.printf("ParallelStreams,%d,%.6f,%.2f%n", N, piStream, duration / 1e6);

            start = System.nanoTime();
            double piFJ = MonteCarloPiForkJoin.estimatePi(N);
            duration = System.nanoTime() - start;
            System.out.printf("ForkJoin,%d,%.6f,%.2f%n", N, piFJ, duration / 1e6);
        }
    }
}
