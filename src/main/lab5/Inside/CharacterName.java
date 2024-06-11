package mortalkombatbversion.src.main.lab5.Inside;
/**
 *
 * @author Кирилл
 */
public enum CharacterName {
    You("You"),
    BARAKA ("Baraka"),
    SONYA_BLADE("Sonya Blade"),
    LIU_KANG ("Liu Kang"),
    SUB_ZERO ("Sub-Zero"),
    SHAO_KAHN ("Shao Kahn");

    private String name;
    CharacterName(String name){
        this.name = name;
    }
    public String getString(){
        return name;
    }
}
