/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.src.main.lab5;


import mortalkombatbversion.src.main.lab5.Inside.EnemyFabric;
import mortalkombatbversion.src.main.lab5.Inside.Player;

/**
 *
 * @author Мария
 */
public class SubZeroFabric implements EnemyFabric {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new SubZero(1, 60, 16, 1);
        return enemy;
    }

}
