package String;

import java.util.*;
import java.util.stream.Collectors;

public class PrintAllAnagramsTogether {

    public List<List<String>> Anagrams(String[] string_list) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res;

        for (String s : string_list) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);

            List<String> tempArr;
            if (!map.containsKey(str)) {
                tempArr = new ArrayList<>();
            } else {
                tempArr = map.get(str);
            }

            tempArr.add(s);
            map.put(str, tempArr);
        }

        res = map.values().stream().filter(t1 -> t1.size() != 0).collect(Collectors.toList());
        return res;
    }
}
