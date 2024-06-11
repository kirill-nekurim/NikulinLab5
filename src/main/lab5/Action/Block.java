package mortalkombatbversion.src.main.lab5.Action;

import mortalkombatbversion.src.main.lab5.Inside.Character;

public class Block extends Action{

    /**
     * @return
     */
    @Override
    public String getType() {
        return "Block";
    }

    /**
     * @param human
     * @param enemy
     * @param enemyActionType
     */
    @Override
    public void realisation(Character human, Character enemy, String enemyActionType) {
    }
}
