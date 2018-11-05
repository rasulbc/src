import java.util.ArrayList;

public class Test {
    public MusicPlayer myPlayer;



    Test(){
        myPlayer = new MusicPlayer();


        int temp=-1;
        int tempId=-1;
        for(int i = 0 ; i < 5 ;i++){
            myPlayer.users.add(new User("user"+i));
            for(int j=0;j<3;j++){

                tempId++;
                myPlayer.users.get(i).addPlaylist("user"+i+"'s playlist"+tempId);
                for(int m = 0 ; m<3;m++){
                    temp++;
                    myPlayer.songs.add(new Song("song"+temp,"Test ", "Test "));
                    myPlayer.addSongToPlaylist(tempId,myPlayer.songs.get(temp));
                }


            }

        }



    }
}
