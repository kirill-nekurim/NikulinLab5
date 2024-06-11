package mortalkombatbversion.src.main.lab5.Action;

import mortalkombatbversion.src.main.lab5.Inside.Character;

public class Debuff extends Action{
    /**
     * @return
     */
    @Override
    public String getType() {
        return "Debuff";
    }

    /**
     * @param human
     * @param enemy
     * @param enemyActionType
     */
    @Override
    public void realisation(Character human, Character enemy, String enemyActionType) {
switch (enemyActionType){
    case "Hit", "Debuff", "Heal" ->{
    }
    case "Block" -> {
        if(Math.random()<0.75){
            enemy.setDebuffTurns(enemy.getLevel());
        }
    }
}
    }
}
