def solution(genres, plays):
    genre_plays = dict()
    genre_songs = dict()
    
    for idx, (genre, play) in enumerate(zip(genres, plays)):
        genre_plays[genre] = genre_plays.get(genre, 0) + play
        genre_songs.setdefault(genre, []).append((idx, play))
    
    genre_plays = sorted(genre_plays.items(), key=lambda x: -x[1])
    for _, songs in genre_songs.items():
        songs.sort(key=lambda x: -x[1])
    
    answer = []
    for genre, _ in genre_plays:
        answer.append(genre_songs[genre][0][0])
        if len(genre_songs[genre]) > 1:
            answer.append(genre_songs[genre][1][0])
    
    return answer