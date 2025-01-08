
import java.util.*;


 class Solution{
            static class Genre implements Comparable<Genre> {
            private int sum;
            private List<Song> songList = new ArrayList<>();

            public Genre() {
            }

            public void addList(Song song) {
                songList.add(song);
                sum += song.getCount();
            }

            public void sortSongList() {
                songList.sort(null);
            }

            public List<Song> getSongList() {
                return songList;
            }

            @Override
            public int compareTo(Genre o) {
                return Integer.compare(o.sum, this.sum);
            }

            @Override
            public String toString() {
                return "Genre{" +
                        "sum=" + sum +
                        ", songList=" + songList +
                        '}';
            }
        }


        static class Song implements Comparable<Song> {
            private int uid;
            private int count;

            public Song(int uid, int count) {
                this.uid = uid;
                this.count = count;
            }

            public int getUid() {
                return uid;
            }

            public int getCount() {
                return count;
            }

            @Override
            public String toString() {
                return "Song{" +
                        "uid=" + uid +
                        ", count=" + count +
                        '}';
            }

            @Override
            public int compareTo(Song o) {
                int result = Integer.compare(o.count, this.count);
                return result == 0 ? Integer.compare(this.uid, o.uid) : result;
            }
        }
     
        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, Genre> genreMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                // 5번 반복
                String genre = genres[i];
                int playCnt = plays[i];
                if (genreMap.containsKey(genre)) {
                    // 있다면 리스트에 추가 및 sum 추가..
                    Genre existedGenre = genreMap.get(genre);
                    existedGenre.addList(new Song(i, playCnt));
                    continue;
                }
                // 없다면? genreMap에 추가
                genreMap.put(genre, new Genre());

                // Genre 내부 리스트에 요소 추가
                Genre existedGenre = genreMap.get(genre);
                existedGenre.addList(new Song(i, playCnt));
            }

            for (Genre genre : genreMap.values()) {
                genre.sortSongList();
            }
            //System.out.println("genreMap = " + genreMap);

            // genreMap의 value 정렬 후 ArrayList로 변환
            ArrayList<Genre> genreArrayList = new ArrayList<>(genreMap.values());
            genreArrayList.sort(null);
            //System.out.println("genreArrayList = " + genreArrayList);


            // 반복하여 정답 뽑기
            ArrayList<Integer> answer = new ArrayList<>();
            for (Genre genre : genreArrayList) {
                List<Song> songList = genre.getSongList();
                if (songList.size() == 1) {
                    Song firstSong = songList.get(0);
                    answer.add(firstSong.getUid());
                    continue;
                }

                for (int i = 0; i < 2; i++) {
                    Song song = songList.get(i);
                    answer.add(song.getUid());
                }
            }
            //System.out.println("answer = " + answer);

            return answer.stream().mapToInt(Integer::intValue).toArray();

        }
 }


