package com.vergilov;


import java.util.*;

public class Main {
private static ArrayList<Album>albums=new ArrayList<Album>();
    public static void main(String[] args) {

        LinkedList<Song> playlists= new LinkedList<>();;
        Album album=new Album("Metallica");
        album.addSong("Fight fire","21354");
        album.addSong("Metal Militia","1:12");
        album.addSong("Master of Puppets","3:12");
        album.addSong("Justice for all","4:13");
        album.addToPlayList(1,playlists);
        album.addToPlayList(2,playlists);
        album.addToPlayList(3,playlists);
        album.addToPlayList(4,playlists);
        albums.add(album);
        albums.get(0).addToPlayList(1,playlists);//Z albumu w arrayliscie

        play(playlists);


    }



    private static void play(LinkedList songs) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingFoward = true;
        ListIterator<Song> listIterator = songs.listIterator();
        printMenu();
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Exit Playlist");
                    quit = true;
                    break;
                case 1:
                    if(songs.isEmpty()){
                        System.out.println("First add songs");
                    }
                    if (!goingFoward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingFoward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingFoward = false;
                    }
                    break;
                case 2:
                    if(songs.isEmpty()){
                        System.out.println("First add songs");
                    }
                    if (goingFoward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingFoward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now Play " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingFoward = true;
                    }
                    break;
                case 3:
                    if(songs.isEmpty()){
                        System.out.println("First add songs");
                    }
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    System.out.println("Now Play " + listIterator.next().toString());
                    break;
                case 4:
                    printPlayList(songs);
                    break;
                case 5:
                    if (!songs.isEmpty()) {
                        listIterator.remove();
                        System.out.println("Current Song Removed");
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing: "+listIterator.next().toString());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing: "+listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("Please go to Song that want to remove( or Playlist is empty)");
                    }
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available Actions:");
        System.out.println("Press:\n0 - to Quit\n1 - Go to next Song" +
                "\n2 - Go to previous Song\n3 - Replay Song\n4 - Show songs in playlist\n5 - Remove Songs\n6 - Print Options");
    }
    public static void printPlayList(LinkedList<Song> linkedList) {
        ListIterator<Song> i = linkedList.listIterator();
        for(int j=0; j<linkedList.size(); j++) {
            if (!linkedList.isEmpty()) {
                System.out.println(i.next().toString());
            } else {
                System.out.println("Is empty");
            }
        }

    }

}
