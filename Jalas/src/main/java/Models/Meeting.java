package Models;

import javax.xml.crypto.Data;

public class Meeting {
    private String title ;
    private Room room;
    private Data data;

    public Meeting(String title, Room room, Data data) {
        this.title = title;
        this.room = room;
        this.data = data;
    }
}
