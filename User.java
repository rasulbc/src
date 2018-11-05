import java.util.ArrayList;
import java.util.Scanner;

public class User {
    static int counter=1;
    final int userId;
    private String userName;
    private ArrayList<Album> listOfAlbums;
    private ArrayList<Playlist> listOfPlaylist ;
    private ArrayList<User> listOfFollowers;
    private ArrayList<User> listOfFollowings;

    User(){

        counter++;
        userId=counter;
        listOfAlbums= new ArrayList<>();
        listOfPlaylist= new ArrayList<>();
        listOfFollowers= new ArrayList<>();
        listOfFollowings= new ArrayList<>();
    }
    User(String name){
        this();
        this.userName=name;

    }
    public int getUserId(){return userId;}
    public String getUserName(){return userName;}
    public ArrayList<Album> getListOfAlbums(){return listOfAlbums;}
    public ArrayList<Playlist> getListOfPlaylist(){return listOfPlaylist;}
    public void addPlaylist(){ listOfPlaylist.add(new Playlist(this.userId)); }
    public void addPlaylist(String sname){ listOfPlaylist.add(new Playlist(sname,this.userId));}
    public void removePlaylist(Playlist playlist){ listOfPlaylist.remove(playlist);}
    public ArrayList<User> getListOfFollowers(){return listOfFollowers;}
    public ArrayList<User> getListOfFollowings(){return listOfFollowers;}


}
