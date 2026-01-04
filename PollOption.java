
package com.example.polls.model;

public class PollOption {
    private String text;
    private int votes;

    public PollOption(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public int getVotes() { return votes; }
    public void vote() { votes++; }
}
