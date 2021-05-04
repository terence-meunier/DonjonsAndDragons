package characters;

import game.Slot;

public interface Player {
    // Drop an item
    void drop(Slot slot);

    // Fight with ennemy
    void fight(Ennemy ennemy);

    // Take damages
    void takeDamages(int damages);

    // Reset Player
    void reset();
}
