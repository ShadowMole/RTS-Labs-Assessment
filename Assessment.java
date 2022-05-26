import java.util.HashMap;
import java.util.List;

public class Assessment {

    public Assessment(){

    }

    /*
      This problem was more annoying to deal with than the string problem. My first solution was to simply loop
      through the list and compare every entry to the comparison number. This method works just fine and should
      cover any and all edge cases. However, I am not sure if it is the most efficient method of solving the problem
      even though it is the easiest to code and most straight forward approach.

      After considering sorting the list  using a merge sort and then using a binary search to locate the comparison
      number within the list, I have realized that it would be less efficient. O(n*log(n)) + O(log(n)) vs O(n).
    */

    public HashMap<String, Integer> aboveBelow(List<Integer> list, int comparison){

        int above = 0;
        int below = 0;

        for(Integer num: list){
            if(num < comparison){
                below++;
            }else if(num > comparison){
                above++;
            }
        }

        HashMap<String, Integer> count = new HashMap<>();

        count.put("Below", below);
        count.put("Above", above);

        return count;
    }
    /*
        My first thought when I saw this problem was to split the String given into charArray and then load
        the array into a queue. After that, I would just need to pop and push the correct amount of times.
        This method was mainly on my mind because the toCharArray method was fresh in my mind from something
        else. However, iterating over the entire String to load it into a queue seemed unnecessary and
        potentially costly if the String was extremely long.

        I thought about simply retrieving the correct length substring from the end of the String and adding
        that to the front of the remaining substring. This is far more efficient and covers almost every case,
        except for if the String needs to rotated more spaces than its length.

        My initial queue solution would cover this edge case, but that solution does come at the cost of efficiency.
        After stepping away from this problem for a day, I came back to realize that using modulo division on the
        rotation amount using the length of the string, it allows for my substring solution to still function
        without any issues.
     */
    public String stringRotation(String original, int rotationAmount){

        rotationAmount = rotationAmount % original.length();
        int splitIndex = original.length() - rotationAmount;
        String newStart = original.substring(splitIndex);
        String newEnd = original.substring(0, splitIndex);

        String rotated = newStart + newEnd;

        return rotated;
    }
}
