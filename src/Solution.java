import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private Scanner scanner;

    private void printIfCancelledForAllTestCases() {
        scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            printIfCancelled();
        }

        scanner.close();
    }

    private void printIfCancelled() {
        int cancellationThreshold = scanner.nextInt();
        List<Integer> arrivalTimes = scanArrivalTimes();

        boolean isCanceled = isProfessorAngry(cancellationThreshold, arrivalTimes);

        System.out.println(isCanceled ? "YES" : "NO");
    }

    private List<Integer> scanArrivalTimes() {
        int numberOfStudents = scanner.nextInt();

        return IntStream.range(0, numberOfStudents)
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toList());
    }

    private boolean isProfessorAngry(int cancellationThreshold, List<Integer> arrivalTimes) {
        long countInTime = arrivalTimes.stream()
                .filter(t -> t <= 0)
                .count();

        return countInTime >= cancellationThreshold;
    }


    public static void main(String[] args) {
        new Solution().printIfCancelledForAllTestCases();
    }
}
