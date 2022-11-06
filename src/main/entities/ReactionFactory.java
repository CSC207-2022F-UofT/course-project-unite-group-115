package entities;

public class ReactionFactory {
    public Reaction create(String reaction, Integer messageID) {
        return new Reaction(reaction, messageID);
    }
}
