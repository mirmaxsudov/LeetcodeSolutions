package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {

    }

    Map<Integer, String> mp = new HashMap<>();

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            int hash = str.hashCode();

            mp.put(hash, str);

            sb.append(hash).append(":");
        }

        if (strs.isEmpty())
            return "";

        return sb.substring(sb.length() - 1);
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty())
            return new ArrayList<>();

        List<String> rs = new ArrayList<>();

        String[] hashes = str.split(":");

        for (String hash : hashes) {
            int h = Integer.parseInt(hash);
            rs.add(mp.get(h));
        }

        return rs;
    }
}
