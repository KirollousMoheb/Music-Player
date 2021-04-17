package com.array;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String albumArtist;
    private  LinkedList<Song> songList;

    public Album(String albumName, String albumArtist) {
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.songList=new LinkedList<>();
    }

    public void addSong(String name,double duration){
        if (findSong(name) == null) {
            songList.add(new Song(name,duration)) ;
        }
    }

    public Song findSong(String name){
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getSongName().equals(name)){
                return songList.get(i);
            }
        }
        return null;
    }

    public void addSongsToPlaylist(int index,LinkedList<Song> playlist){
        if (index-1>=0 && index-1<= playlist.size()) {
            playlist.add(songList.get(index-1));
        }
        else{
            System.out.println("The album doesn't contain this song");

        }
    }

    public void addSongsToPlaylist(String name,LinkedList<Song> playlist){
        if (findSong(name)!=null) {
            playlist.add(findSong(name));
        }
        else{
            System.out.println("The album doesn't contain this song");

        }
    }

}
