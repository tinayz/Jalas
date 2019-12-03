package Models;

public class VoteOption {
    private Time start ;
    private Time end;
    private int numOfAgrrements ;
    private int getNumOfDisAgrrements ;

    @Override
    public String toString() {
        return "VoteOption{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", numOfAgrrements=" + numOfAgrrements +
                ", getNumOfDisAgrrements=" + getNumOfDisAgrrements +
                '}';
    }

    public VoteOption(Time start, Time end, int numOfAgrrements, int getNumOfDisAgrrements) {
        this.start = start;
        this.end = end;
        this.numOfAgrrements = numOfAgrrements;
        this.getNumOfDisAgrrements = getNumOfDisAgrrements;
    }

    public static VoteOption getVoteOption(){
        return new VoteOption(new Time(5 , 12,2019 ,18),new Time(5 , 12,2019 ,18) , 5 , 10);
    }

}
