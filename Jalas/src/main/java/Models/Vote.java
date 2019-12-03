package Models;

import java.util.ArrayList;

public class Vote {
    private String title ;
    private ArrayList<VoteOption> voteOptions ;

    public Vote(String title) {
        this.title = title;
        this.voteOptions = new ArrayList<>();
    }
    public void addVoteOption(VoteOption voteOption){
        voteOptions.add(voteOption);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "title='" + title + '\'' +
                ", voteOptions=" + voteOptions +
                '}';
    }

    public static Vote getVote(){
        Vote vote = new Vote("ieee_2019");
        vote.addVoteOption(VoteOption.getVoteOption());
        return vote;
    }
}
