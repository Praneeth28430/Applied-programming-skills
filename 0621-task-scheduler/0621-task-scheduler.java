import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // Sort frequencies to easily find the maximum frequencies
        Arrays.sort(frequencies);
        
        // The highest frequency of any task
        int maxFreq = frequencies[25];
        
        // Calculate the maximum possible idle slots required by just organizing the most frequent task
        int idleSlots = (maxFreq - 1) * n;
        
        // Step 2: Reduce idle slots by filling them up with other available tasks
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            // A task with the same maximum frequency can only fill up to (maxFreq - 1) slots 
            // because its final instance will run after the last chunk of the most frequent task
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]);
        }
        
        // Idle slots cannot be negative
        idleSlots = Math.max(0, idleSlots);
        
        // Total intervals = total number of tasks + remaining empty idle slots
        return tasks.length + idleSlots;
    }
}
