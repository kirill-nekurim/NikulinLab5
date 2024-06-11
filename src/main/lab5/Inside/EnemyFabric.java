package mortalkombatbversion.src.main.lab5.Inside;

import static mortalkombatbversion.src.main.lab5.Inside.CharacterName.*;

/**
 *
 * @author Кирилл
 */
public class EnemyFabric {

    public Character create(CharacterName name){
        return switch (name){
            default -> null;
            case BARAKA -> new Character(1,100,12,BARAKA);
            case LIU_KANG -> new Character(1,70,20, LIU_KANG);
            case SONYA_BLADE -> new Character(1,80,16,SONYA_BLADE);
            case SUB_ZERO  -> new Character(1,60,16,SUB_ZERO );
            case SHAO_KAHN   -> new Character(3,100,30,SHAO_KAHN  );
        };
    }
}
