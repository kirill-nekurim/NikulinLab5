package mortalkombatbversion.src.main.lab5.Actions;

import mortalkombatbversion.src.main.lab5.Inside.Character;

public class Heal extends Action{

    /**
     * @return
     */
    @Override
    public String getType() {
        return "Heal";
    }

    /**
     * @param human
     * @param enemy
     * @param enemyActionType
     */
    @Override
    public void realisation(Character human, Character enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit", "Heal", "Debuff" -> {
            }
            case "Block" ->{
            human.addHealth((human.getMaxHealth() - human.getHealth())/2);
            }
        }
    }
}
