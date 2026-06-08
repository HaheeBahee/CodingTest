import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        Map<String, List<int[]>> songMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        
        List<String> genreSorted = new ArrayList<>(totalPlays.keySet());
        genreSorted.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : genreSorted) {
            List<int[]> songList = new ArrayList<>(songMap.get(genre));
            songList.sort((a, b) -> b[1] - a[1]);
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                result.add(songList.get(i)[0]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}