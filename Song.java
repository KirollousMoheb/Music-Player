package com.array;

public class Song {
    private String songName;
    private double songDuration;

    public Song(String songName, double songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "Name='" + songName + '\'' +
                ", Duration= " + songDuration +
                '}';
    }
}
