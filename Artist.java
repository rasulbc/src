import java.util.ArrayList;

public class Artist {
    private String name;
    private String country;
    private String musicType;
    public ArrayList<Song> artistSongs;

    Artist(){
        artistSongs= new ArrayList<>();
    }
    Artist(String aName){
        this();
        name=aName;
    }
    Artist(String aName, String aCountry){
        this(aName);
        country=aCountry;
    }
    Artist(String aName,String aCountry , String aMusicType){
        this(aName,aCountry);
        musicType=aMusicType;
    }

    public String getName(){return name;}

    public String getCountry() {return country; }

    public String getMusicType() { return musicType;}

}
