import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    public ArrayList<User> users;
    public ArrayList<Song> songs;


    MusicPlayer(){
        users = new ArrayList<>();
        songs = new ArrayList<>();
    }

    public void menu(){
        int id;
        String temp;
        Scanner input = new Scanner(System.in);
        String option="1";
        while (option!="0"){

            System.out.println("\nOptions:" +
                    "\n1.  Add user" +
                    "  2.  Delete user" +
                    "  3.  Get user details" +
                    "\n4.  Add song" +
                    "  5.  Delete song" +
                    "  6.  Get song album" +
                    "\n7.  Add playlist to user" +
                    "  8.  Add song to playlist" +
                    "\n9.  Get playlist details" +
                    "  10. Delete Playlist" +
                    "\n11. Display users" +
                    "  12. Display songs" +
                    "\n0.  Exit");
            option = input.next();
            switch (option){
                case "1":
                    addUser();
                    break;
                case "2": deleteUser();
                    break;
                case "3":
                    System.out.print("Please enter the Users ID:");
                    id=input.nextInt();
                    getUserDetails(id);
                    break;
                case "4": addSong();
                    break;
                case "5": deleteSong();
                    break;
                case "6":
                    System.out.println("\nPlease enter the Song ID:");
                    id=input.nextInt();
                    if(getSongAlbum(id)!=null) System.out.println("\nThis song is in " + getSongAlbum(id) + " album.");
                    else System.out.println("\nSong with id "+id+" was not found");
                    break;
                case "7":

                    int user_id;
                    System.out.print("Enter User ID for adding a new playlist:");
                    user_id=input.nextInt();
                    addPlaylistUser(user_id);
                    break;
                case "8":
                    System.out.println("Enter Playlist Id for adding a song:");
                    id=input.nextInt();
                    addSongToPlaylist(id);
                    break;
                case "9":
                    System.out.println("\nEnter the playlist id:");
                    id=input.nextInt();
                    getPlaylistDetails(id);
                case "10":
                    deletePlaylist();
                    break;
                case "11":
                    displayUsers();
                    break;
                case "12":
                    displaySongs();
                    break;
                case "0":
                    System.out.println("Exiting the menu");
                    break;

                default:
                    System.out.println("Wrong Input, please try again.");


            }
        }



    };
    public void addUser(){
        String temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the users Name: ");
        temp=input.next();
        User aUser = new User(temp);
        users.add(aUser);
        System.out.println("User created:\nUsername: "+aUser.getUserName()+" ,User ID: "+aUser.getUserId());

    };
    public void deleteUser(){
        int found = 0;
        System.out.println("Enter the User's ID to delete:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for(User user:users){
            if(id == user.getUserId()){
                found = 1;
                users.remove(user);
                System.out.println("Userid "+id+" deleted successfully");
                break;
            }

        }

        if (found == 0 )  System.out.println("User with that id was not found.");
    };
    public void getUserDetails(int user_id){

        int found = 0;
        for( User user:users){
            if(user_id == user.getUserId()){
                found = 1;
                System.out.println("\nUser ID: "+ user.getUserId());
                System.out.println("Username: "+ user.getUserName());
                System.out.println("Albums: ");
                for (Album album : user.getListOfAlbums()){
                    System.out.print(album.getName());
                }

                System.out.print("Playlists: ");
                for (Playlist playlist : user.getListOfPlaylist()){
                    System.out.print("\n        Name: " + playlist.getName()+"   ID: "+playlist.getPlayListId());
                }

                System.out.println("\nFollowers: ");
                for (User user1 : user.getListOfFollowers()){
                    System.out.print(" " +user1.getUserName()+",");
                }

                System.out.println("Followings: ");
                for (User user2 : user.getListOfFollowings()){
                    System.out.print(" " +user2.getUserName()+",");
                }
                break;
            }
        }
        if (found == 0 )  System.out.println("User with that id was not found.");
    }
    public void addSong(){

        String temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the users Name: ");
        temp=input.next();
        Song aSong = new Song(temp);
        songs.add(aSong);
        System.out.println("Song created:\nSong Name: "+aSong.getSongName()+" Song ID: "+aSong.getSongId());
    }
    public void deleteSong(){
        int found = 0 ;
        System.out.println("Enter the Song's ID to delete:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for(Song song:songs){
            if(id == song.getSongId()){
                found = 1;
                songs.remove(song);
                System.out.println("SongId "+id+" deleted successfully");
                break;
            }

        }
        if (found == 0 )  System.out.println("Song with that id was not found.");
    }
    public String getSongAlbum(int song_id){
        for (Song song : songs){
            if(song_id==song.getSongId()) {
                return song.getAlbumName();
            }
        }
        return null;
    }
    public void addPlaylistUser(int user_id){
        for (User user: users){
            if(user_id == user.getUserId()){
                user.addPlaylist();
                break;
            }
        }
    }
    public void addSongToPlaylist(int playlist_id){
        int song_id;
        A: for (User user: users){
            B: for (Playlist playlist: user.getListOfPlaylist()){
                if(playlist_id == playlist.getPlayListId()){
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter the Song ID to add to playlist:");
                    song_id = input.nextInt();
                    for(Song song:songs){
                        if (song_id==song.getSongId()){
                            playlist.addSong(song);
                            break A;
                        }
                    }
                }
            }
        }
    }
    public void addSongToPlaylist(int playlist_id,Song one){
        A: for (User user: users){
            B: for (Playlist playlist: user.getListOfPlaylist()){
                if(playlist_id == playlist.getPlayListId()){
                    playlist.addSong(one);
                    break A;
                }
            }
        }
    }
    public void getPlaylistDetails(int playlist_id){
        A: for (User user: users){
            B: for (Playlist playlist: user.getListOfPlaylist()){
                if(playlist_id == playlist.getPlayListId()){
                    System.out.println("\nPlaylist Details:");
                    System.out.println("\nName: "+playlist.getName());
                    System.out.println("\nID: "+playlist.getPlayListId());
                    System.out.println("\nOwner ID: "+playlist.getOwner());
                    System.out.println("\nCreation date: "+playlist.getDateCreated().toString());
                    System.out.println("\nSongs : ");
                    for(Song song:playlist.getSongs()){
                        System.out.println(song.getSongName());
                    }
                    break A;

                }
            }
        }
    }
    public void deletePlaylist(){
        Scanner input = new Scanner(System.in);
        int playlist_id;
        System.out.print("\nEnter playlist ID to delete: ");
        playlist_id=input.nextInt();
        A: for (User user: users){
            B: for (Playlist playlist: user.getListOfPlaylist()){
                if(playlist_id == playlist.getPlayListId()){
                    user.removePlaylist(playlist);
                    break A;
                }

            }
        }
    }
    public void displayUsers(){
        for(int i = 0; i<users.size();i++){
            System.out.println("UserId:  " + users.get(i).getUserId() + "   Username: " + users.get(i).getUserName());
        }
    };
    public void displaySongs(){
        for(int i = 0; i<songs.size();i++){
            System.out.println("SongId:  " + songs.get(i).getSongId() + "   Song Name: " + songs.get(i).getSongName());
        }
    };

    public static void main(String[] args){
        Test lox = new Test();
        lox.myPlayer.menu();


    }
}
