package com.array;

import java.util.*;

public class Main {
    private static LinkedList <Album> albums=new LinkedList<>();
    private static LinkedList <Song> playlist=new LinkedList<>();
    private static Scanner scanner=new Scanner(System.in);
    private static boolean next=true;


    private static void displayMenu() {
        System.out.println("Welcome to the Music Player");
        System.out.println("1)Play next Song in the Playlist");
        System.out.println("2)Play previous Song");
        System.out.println("3)Replay the Current playing Song");
        System.out.println("4)Remove the Current playing Song");
        System.out.println("5)Display Menu");
        System.out.println("6)Show Playlist");
        System.out.println("7)Exit");
    }
    private static void loadData(){

        Album amrDiab=new Album("El lela","Amr Diab");
        amrDiab.addSong("Tmly m3ak",2);
        amrDiab.addSong("lely nhary n",2.5);
        amrDiab.addSong("7abebe",2.6);
        amrDiab.addSong("sbt fra8",4);
        amrDiab.addSongsToPlaylist(1,playlist);
        amrDiab.addSongsToPlaylist(2,playlist);
        amrDiab.addSongsToPlaylist(3,playlist);
        amrDiab.addSongsToPlaylist(4,playlist);




    }
    private static void printPlaylist(){
        if (playlist.size()>0){
            System.out.println("==============Current Playlist Songs============");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println(playlist.get(i).toString());
            }
            System.out.println("===========================================");

        }
    }
    private static void remove(ListIterator<Song> iterator){
        if(playlist.size()>0){
            System.out.println("The current playing Song was removed");
            iterator.remove();

            if (iterator.hasNext()){
                System.out.println("Now Playing "+iterator.next().toString());
            }
            else if (iterator.hasPrevious()){
                System.out.println("Now Playing "+iterator.previous().toString());
            }
        }else{
            System.out.println("The Playlist is empty!Nothing to remove.");
        }

    }

    private static void playNext(ListIterator<Song> iterator){
        if (!next){
            if (iterator.hasNext()){
                iterator.next();
            }
            next=true;
        }
        if (iterator.hasNext()){
            System.out.println("Playing "+iterator.next().toString());
        }
        else{
            System.out.println("Reached the end of the playlist");

            next=false;

        }
    }
    private static void playPrevious(ListIterator<Song> iterator){

        if (next){
            if (iterator.hasPrevious()){
                iterator.previous();
            }
            next=false;
        }
        if (iterator.hasPrevious()){
            System.out.println("Playing "+iterator.previous().toString());
        }
        else{
            System.out.println("Reached the beginning of the playlist");

            next=true;

        }
    }
    private static void replay(ListIterator<Song> iterator) {
        if(next) {

            if(iterator.hasPrevious()) {
                System.out.println("Now playing " + iterator.previous().toString());
                iterator.next();
            } else {
                System.out.println("You're at the beginning of the list.");
            }
        } else {
            if(iterator.hasNext()) {
                iterator.next();
                System.out.println("Now playing " + iterator.previous().toString());
            } else {
                System.out.println("You are at the end of the list.");
            }
        }
    }
    public static void main(String[] args) {
        loadData();
        ListIterator<Song> iterator=playlist.listIterator();
        displayMenu();
        boolean exit=false;
        while (!exit){
            int option=scanner.nextInt()-1;
            switch (option){
                case 0:
                    playNext(iterator);
                    break;
                case 1:
                    playPrevious(iterator);
                    break;
                case 2:
                    replay(iterator);

                    break;

                case 3:
                    remove(iterator);
                    break;

                case 4:
                    displayMenu();
                    break;
                case 5:
                    printPlaylist();
                    break;
                case 6:
                    exit=true;
                    break;


            }
        }


    }
}
