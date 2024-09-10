import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ElectionTest {

    private Election election;

    @BeforeEach
    public void setUp() {
        election = new Election();
    }

    @Test
    public void testAddCandidate() throws ElectionException {
        election.addCandidate("bhagya");
        election.addCandidate("pooja");
        assertThrows(ElectionException.class, () -> election.addCandidate("bhagya"));
    }

    @Test
    public void testCastVote() throws ElectionException {
        election.addCandidate("bhagya");
        election.castVote("bhagya");
        assertThrows(ElectionException.class, () -> election.castVote("bhagya"));
    }

    @Test
    public void testDisplayVotes() throws ElectionException {
        election.addCandidate("bhagya");
        election.castVote("bhagya");
        election.displayVotes(); // You can manually check the output in this case
    }

    @Test
    public void testDeclareWinner() throws ElectionException {
        election.addCandidate("bhagya");
        election.addCandidate("pooja");
        election.castVote("bhagya");
        election.declareWinner();
    }

    @Test
    public void testDeclareWinnerNoVotes() {
        assertThrows(ElectionException.class, () -> election.declareWinner());
    }
}
