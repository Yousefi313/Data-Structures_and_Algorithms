import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> uniqueRandomNumbers = generateUniqueRandomNumbers(20, 0, 100);
        System.out.println("Unique Random Numbers: " + uniqueRandomNumbers);

        // Sort the unique random numbers using streams
        List<Integer> sortedNumbers = uniqueRandomNumbers.stream()
                                                         .sorted()
                                                         .collect(Collectors.toList());
        System.out.println("Sorted Unique Random Numbers:\n " + sortedNumbers);

        // Example usage of linear and binary search
        int target = 37; // Example target number
        int[] sortedArray = sortedNumbers.stream().mapToInt(Integer::intValue).toArray();
        
        int linearSearchResult = linearSearch(sortedArray, target);
        System.out.println("Linear Search Result: " + (linearSearchResult != -1 ? "Found at index " + linearSearchResult : "Not Found"));
    }

    public static Set<Integer> generateUniqueRandomNumbers(int count, int min, int max) {
        if (count > (max - min + 1)) {
            throw new IllegalArgumentException("Count is larger than the range of numbers.");
        }

        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < count) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers;
    }

    public static int linearSearch(int[] nums, int target){

        int step = 0;

        for(int i = 0; i < nums.length; i++){
            step++;
            if(nums[i] == target){
                System.out.println("Steps taken in linear search: " + step);
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target){
        int step = 0;
        // Binary search requires the array to be sorted
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            step++;
            // Calculate the middle index
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                System.out.println("Steps taken in binary search: " + step);
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
        }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}