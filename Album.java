import java.util.Date;
import java.util.ArrayList;

public class Album {
    private String name;
    private String genre;
    private Date releaseDate;
    public ArrayList<Song> albumSongs;

    Album(){
        albumSongs= new ArrayList<>();
        releaseDate = new Date();

    }
    Album(String aName){
        this();
        name=aName;

    }
    Album(String aName, String aGenre){
        this(aName);
        genre=aGenre;
    }

    public String getName(){return name;}
    public String getGenre(){return genre;}
    public Date getReleaseDate(){return releaseDate;}


}

