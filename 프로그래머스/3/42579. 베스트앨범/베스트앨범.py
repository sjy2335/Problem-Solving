def solution(genres, plays):
    genre_plays = {}
    genre_songs = {}

    for idx, (genre, play) in enumerate(zip(genres, plays)):
        genre_plays[genre] = genre_plays.get(genre, 0) + play
        genre_songs.setdefault(genre, []).append((idx, play))

    sorted_genres = sorted(genre_plays, key=lambda x: -genre_plays[x]) # returns a list of keys

    answer = []
    for genre in sorted_genres:
        songs = sorted(genre_songs[genre], key=lambda x: (-x[1], x[0]))
        answer.extend([idx for idx, play in songs[:2]])

    return answer