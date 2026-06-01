import java.io.*;
import java.util.*;

class WordInfo {
    int frequency = 0;
    Set<Integer> lines = new HashSet<>();
}

public class DocumentDictionary {
    public static void main(String[] args) throws Exception {
        HashMap<String, WordInfo> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("document.txt"));

        String line;
        int lineNo = 0;

        while ((line = br.readLine()) != null) {
            lineNo++;
            line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

            for (String word : line.split("\\s+")) {
                if (word.isEmpty()) continue;

                WordInfo info = map.getOrDefault(word, new WordInfo());
                info.frequency++;
                info.lines.add(lineNo);
                map.put(word, info);
            }
        }
        br.close();

        for (Map.Entry<String, WordInfo> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> Frequency: " +
                    e.getValue().frequency + ", Lines: " + e.getValue().lines);
        }
    }
}