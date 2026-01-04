
package com.example.polls.repo;

import com.example.polls.model.*;
import java.util.*;

public class PollRepository {
    private static List<Poll> polls = new ArrayList<>();
    private static int counter = 1;

    public static List<Poll> findAll() { return polls; }

    public static Poll findById(int id) {
        return polls.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static void add(String question, List<String> opts) {
        List<PollOption> options = new ArrayList<>();
        for (String o : opts) {
            if (o != null && !o.trim().isEmpty())
                options.add(new PollOption(o));
        }
        polls.add(new Poll(counter++, question, options));
    }

    public static void vote(int pollId, int optionIndex) {
        Poll p = findById(pollId);
        if (p != null) {
            p.getOptions().get(optionIndex).vote();
        }
    }

    public static void delete(int id) {
        polls.removeIf(p -> p.getId() == id);
    }
}
