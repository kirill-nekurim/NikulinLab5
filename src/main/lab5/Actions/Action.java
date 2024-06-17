package mortalkombatbversion.src.main.lab5.Actions;

import mortalkombatbversion.src.main.lab5.Inside.Character;

public abstract class Action {
public abstract String getType();
public abstract void realisation(Character human, Character enemy, String enemyActionType);
}
