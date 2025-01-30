package by.smuglyakov.testproject.service;

import by.smuglyakov.testproject.model.Unit;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Queue;

@Service
public class ConsumerImpl {
    //time period in minutes
    private static final Integer TIME_PERIOD = 5;
    private Queue<Unit> queue;
    private int sum = 0;

    public ConsumerImpl() {
        queue = new ArrayDeque<>();
    }

    public void accept(int number) {
        long currentTime = System.currentTimeMillis();
        removeOldUnits(currentTime);
        queue.add(new Unit(number, currentTime));
        sum += number;
    }

    public Double mean() {
        long currentTime = System.currentTimeMillis();
        removeOldUnits(currentTime);
        if (queue.isEmpty()) {
            return null; // No numbers in the last 5 minutes
        }
        return (double) sum / queue.size();
    }

    // method to remove entries older than 5 minutes
    private void removeOldUnits(long currentTime) {
        while (!queue.isEmpty() && currentTime - queue.peek().getTimestamp() > TIME_PERIOD * 60 * 1000) {
            Unit oldEntry = queue.poll();
            sum -= oldEntry.getValue();
        }
    }
}
