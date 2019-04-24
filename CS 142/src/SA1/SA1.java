/**
 * Name:Chaolun Feng
 * SA1:Basic Programming Competence
 */
public class SA1 {
    /**
     * Main method
     */
    public static void main(String[] args) {
        //declare an array that can hold 15 integer values
        int [] arr = new int [15];
        //use a loop to put the integer values 5, 6, 7, … 18, 19 into the array
        for(int i = 0; i < 15; i++) {
            arr[i] = 5+i;
        }
        //pass the array to the helper function which will return an integer value
        int sum = helper(arr);
        //print out the value returned by the helper function
        System.out.println(sum);
    }

    /**
     * This is a helper method that returns the sum of odd numbers and number divisible by 3 in the array
     * @param arr input array
     * @return  sum of odd numbers and number divisible by 3 in the array
     */
    public static int helper(int [] arr) {
        int sum = 0;
        //traverse the array values found in the array, totaling the values that are odd or a multiple of 3.
        for(int i =0; i < arr.length; i++) {
            if((arr[i]%3 == 0) || (arr[i]%2 ==1)){
                sum = sum + arr[i];
            }
        }
        //return the sum of those values.
        return sum;
    }
}
