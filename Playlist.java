import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Playlist {

    static int counter=1;
    private final int playListId;
    private String name;
    private int owner;
    private Date dateCreated;
    private ArrayList<Song> songs ;

    Playlist(){

        counter++;
        playListId=counter;
        songs = new ArrayList<>();
        dateCreated = new Date();
    }
    Playlist(int id){
        this();
        owner=id;

    }
    Playlist(String name, int id){
        this(id);
        this.name=name;

    }

    public int getPlayListId(){return playListId;}
    public String getName(){return name;}
    public int getOwner(){return owner;}
    public Date getDateCreated(){return dateCreated;}

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song addThisSong){
        songs.add(addThisSong);
    }
}
