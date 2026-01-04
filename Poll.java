
package com.example.polls.model;

import java.util.List;

public class Poll {
    private int id;
    private String question;
    private List<PollOption> options;

    public Poll(int id, String question, List<PollOption> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public int getId() { return id; }
    public String getQuestion() { return question; }
    public List<PollOption> getOptions() { return options; }
}
