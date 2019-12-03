package Models;


public class Room{

    private String state ;
    private String location ;
    private Time setTime ;

    public  Room(String state, String location, Time setTime){
           this.state =state ;
           this.location = location ;
           this.setTime = setTime;
    }
}