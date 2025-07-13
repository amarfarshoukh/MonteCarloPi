package edu.pi.simulation;

public class Main {
    public static void main(String[] args) {
        int N = 10_000_000;

        long start = System.nanoTime();
        double piSeq = MonteCarloPiSequential.estimatePi(N);
        System.out.println("Sequential Pi: " + piSeq + " in " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        double piStream = MonteCarloPiParallelStreams.estimatePi(N);
        System.out.println("Parallel Streams Pi: " + piStream + " in " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        double piFJ = MonteCarloPiForkJoin.estimatePi(N);
        System.out.println("Fork/Join Pi: " + piFJ + " in " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}


