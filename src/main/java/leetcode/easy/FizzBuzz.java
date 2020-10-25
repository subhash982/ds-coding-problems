package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output Fizz instead of the number and for the multiples of five output Buzz. For numbers which are multiples of both three and five output FizzBuzz.
 * Example:
 * n = 15,
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList <>();
        if(n > 0){
            for (int i=1;i <=n;i++){
                result.add(i%3==0 ? i%5==0 ? "FizzBuzz" : "Fizz" : i%5==0 ? i%3==0 ? "FizzBuzz" : "Buzz" : String.valueOf(i));
            }
        }
        return result;

        //Solution 2
//           IntStream.rangeClosed(1, 100)
//                .mapToObj(i->i%3==0 ? i%5==0 ? "FizzBuzz" : "Fizz" : i%5==0 ? i%3==0 ? "FizzBuzz" : "Buzz" : String.valueOf(i)).collect(Collectors.toList());

    }
}
