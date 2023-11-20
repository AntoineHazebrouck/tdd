package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import jez.factories.AssignmentPairFactory;

public class Application {

    public static void main(String[] args) throws IOException {
        String path =
                "C:\\Users\\Jez\\Desktop\\travail\\cours\\BUT3\\tdd\\day4-camp-cleanup\\src\\main\\ressources\\input.txt";
        String fileAsString = new String(Files.readAllBytes(Paths.get(path)));

        AssignmentPairFactory assignmentPairFactory = new AssignmentPairFactory();

        final AtomicInteger count = new AtomicInteger(0);
        fileAsString.lines().forEach(line -> {
            AssignmentPair assignmentPair = assignmentPairFactory.getAssignmentPair(line);

            Range left = assignmentPair.getLeft();
            Range right = assignmentPair.getRight();

            if (left.overlaps(right)) {
                count.incrementAndGet();
            }
            // if (left.contains(right) || left.isContainedBy(right))
            //     count.incrementAndGet();
        });

        System.out.println(count);
    }
}
