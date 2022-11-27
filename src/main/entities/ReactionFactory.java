package entities;

public class ReactionFactory {
    public Reaction create(String reaction, String messageID) {
        return new Reaction(reaction, messageID);
    }
}
