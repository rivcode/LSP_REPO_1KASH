package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a voting machine that manages candidates and their votes
 */
public class VotingMachine {
    private Map<String, Integer> candidateVotes;

    /**
     * Constructor initializes an empty map to store candidate votes
     */
    public VotingMachine() {
        this.candidateVotes = new HashMap<>();
    }

    /**
     * Adds a new candidate to the voting machine
     * @param name The name of the candidate to add
     */
    public void addCandidate(String name) {
        candidateVotes.put(name, 0);
    }

    /**
     * Casts a vote for the specified candidate
     * @param name The name of the candidate to vote for
     * @return true if the vote was successful, false if the candidate doesn't exist
     */
    public boolean castVote(String name) {
        if (!candidateVotes.containsKey(name)) {
            return false;
        }
        candidateVotes.put(name, candidateVotes.get(name) + 1);
        return true;
    }

    /**
     * Gets the winner of the election
     * @return A string announcing the winner and their vote count
     */
    public String getWinner() {
        if (candidateVotes.isEmpty()) {
            return "No candidates in the election";
        }

        String winner = "";
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
} 