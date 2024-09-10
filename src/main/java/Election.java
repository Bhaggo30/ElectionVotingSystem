import java.util.HashMap;
import java.util.Map;

public class Election {

    private Map<String, Integer> candidates;

    public Election() {
        candidates = new HashMap<>();
    }

    public void addCandidate(String name) throws ElectionException {
        name = name.toLowerCase();
        if (!candidates.containsKey(name)) {
            candidates.put(name, 0);
            System.out.println("Candidate " + name + " added successfully.");
        } else {
            throw new ElectionException("Candidate " + name + " already exists.");
        }
    }

    public void castVote(String name) throws ElectionException {
        name = name.toLowerCase();
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
            System.out.println("Vote cast for " + name + ".");
        } else {
            throw new ElectionException("Candidate " + name + " does not exist.");
        }
    }

    public void displayVotes() {
        System.out.println("Votes received by each candidate:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void declareWinner() throws ElectionException {
        if (candidates.isEmpty()) {
            throw new ElectionException("No candidates in the election.");
        }

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        if (winner != null) {
            System.out.println("The winner of the election is " + winner + " with " + maxVotes + " votes.");
        } else {
            throw new ElectionException("No votes cast in the election.");
        }
    }

    public void showAllCandidates() {

    }
}
