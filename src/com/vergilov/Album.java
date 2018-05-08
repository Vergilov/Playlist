package com.vergilov;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }


    public boolean addSong(String title, String duration) {
        if (findSong(title) >= 0) {
            System.out.println("Song is already on file");
            return false;
        }
        Song newSong = new Song(title, duration);
        songs.add(newSong);
        return true;
    }


    public void printAlbum() {
        System.out.println("Album: ");
        for (int i = 0; i < this.songs.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.songs.get(i).getTitle() + " - Duration: " +
                    this.songs.get(i).getDuration());
        }

    }

    private int findSong(Song song) {
        return this.songs.indexOf(song);

    }

    private int findSong(String nameSong) {
        for (int i = 0; i < songs.size(); i++) {
            Song song = this.songs.get(i);
            if (song.getTitle().equals(nameSong)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0 )&& index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("Album does not have a track "+trackNumber);
        return false;
    }


}


