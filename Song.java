import java.util.Date;

public class Song {
    private static int counter =1;
    final int songId;
    private String songName;
    private String albumName;
    private String artistName;
    private String genre;
    private Date releaseDate;

    Song(){
        counter++;
        songId=counter;
        releaseDate = new Date();

    }
    Song(String sName){
        this();
        songName=sName;
    }
    Song(String sName,String aName){
        this(sName);
        albumName=aName;
    }
    Song(String sName,String aName,String aArtistName){
        this(sName,aName);
        artistName=aArtistName;
    }
    Song(String sName,String aName,String aArtistName,String aGenre){
        this(sName,aName,aArtistName);
        genre=aGenre;
    }
    public int getSongId(){return songId;}
    public String getSongName(){return songName;}
    public String getAlbumName(){return albumName;}
    public String getArtistName(){return artistName;}
}
