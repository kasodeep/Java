package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonElementsThreeArrays {

    static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C, int n1, int n2, int n3) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : A) map.put(num, 1);

        for (int num : B) {
            if (map.containsKey(num) && map.get(num) == 1) map.put(num, 2);
        }

        for (int num : C) {
            if (map.containsKey(num) && map.get(num) == 2) map.put(num, 3);
        }

        return map.entrySet().stream().filter(entry -> entry.getValue() == 3).map(Map.Entry::getKey).sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
