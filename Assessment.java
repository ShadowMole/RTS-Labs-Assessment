import java.util.HashMap;
import java.util.List;

public class Assessment {

    public Assessment(){

    }

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

    public String stringRotation(String original, int rotationAmount){

        int splitIndex = original.length() - rotationAmount;
        String newStart = original.substring(splitIndex);
        String newEnd = original.substring(0, splitIndex);

        String rotated = newStart + newEnd;

        return rotated;
    }
}
