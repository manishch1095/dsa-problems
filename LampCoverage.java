import java.util.*;

public class LampCoverage {

    public static void main(String[] args) {
        // Example intervals for lamps and points to check
        int[][] lamps = {{1, 5}, {2, 6}, {3, 7}, {4, 8}};  // Lamp intervals
        int[] points = {4, 6, 2};  // Points to check

        // Count coverage for each point
        int[] result = countLampCoverage(lamps, points);

        // Print the result for each point in the original order
        for (int i = 0; i < points.length; i++) {
            System.out.println("The point " + points[i] + " is covered by " + result[i] + " lamps.");
        }
    }

    // Function to count how many lamps cover each point
    public static int[] countLampCoverage(int[][] lamps, int[] points) {
        int n = lamps.length;
        int m = points.length;

        // Step 1: Create events for all lamps (start and end)
        List<int[]> events = new ArrayList<>();
        
        // Add start and end events for each lamp
        for (int[] lamp : lamps) {
            events.add(new int[] {lamp[0], 1});  // Start event: lamp starts affecting points
            events.add(new int[] {lamp[1] + 1, -1});  // End event: lamp stops affecting points (exclusive)
        }
        
        // Sort events: first by position, then by event type (end event should come after start event if they occur at the same position)
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Step 2: Pair the points with their original indices so we can restore the order later
        int[] sortedPoints = Arrays.copyOf(points, m);
        Integer[] originalIndices = new Integer[m];
        for (int i = 0; i < m; i++) {
            originalIndices[i] = i;  // Storing original indices
        }

        // Step 3: Sort the indices based on the values in the points array
        Arrays.sort(originalIndices, (a, b) -> Integer.compare(points[a], points[b]));

        // Step 4: Sweep through the events and calculate coverage for each point
        int[] result = new int[m];
        int activeLamps = 0;
        int eventIdx = 0;

        // For each point (processed in sorted order), count the active lamps that cover it
        for (int idx : originalIndices) {
            int point = points[idx];

            // Process all events that occur before or at the point
            while (eventIdx < events.size() && events.get(eventIdx)[0] <= point) {
                int[] event = events.get(eventIdx++);
                activeLamps += event[1];  // Update the count of active lamps
            }

            // Store the result for the current point (using the original index to maintain order)
            result[idx] = activeLamps;
        }

        return result;
    }
}
