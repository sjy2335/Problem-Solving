import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genreCountMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genreSongInfoMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!genreCountMap.containsKey(genre)) {
                genreCountMap.put(genre, 0);
                genreSongInfoMap.put(genre, new ArrayList<>());
            }
            
            genreCountMap.put(genre, genreCountMap.get(genre) + play);
            genreSongInfoMap.get(genre).add(new int[]{i, play});
        }
        
        Stream<Map.Entry<String, Integer>> sortedGenreCount = genreCountMap
            .entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenreCount.forEach(entry -> {
            Stream<int[]> sortedSongs = genreSongInfoMap
                .get(entry.getKey())
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);

            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}