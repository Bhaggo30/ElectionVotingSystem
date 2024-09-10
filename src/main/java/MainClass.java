import java.util.Scanner;
public class MainClass {

    public static void main(String[] args) throws ElectionException {
        Election election = new Election(); // Specify the max number of candidates
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nElection System Menu:");
            System.out.println("1. Add Candidate");
            System.out.println("2. Cast Vote");
            System.out.println("3. Display Votes");
            System.out.println("4. Declare Winner");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter candidate name:");
                    String candidateName = sc.nextLine();
                    election.addCandidate(candidateName);
                    break;
                case 2:
                    System.out.println("Candidate names:");
                    election.showAllCandidates();
                    System.out.println("Enter candidate name to vote for:");
                    String voteCandidateName = sc.nextLine();
                    election.castVote(voteCandidateName);
                    break;
                case 3:
                    election.displayVotes();
                    break;
                case 4:
                    election.declareWinner();
                    break;
                case 5:
                    System.out.println("Exiting the Election System");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
