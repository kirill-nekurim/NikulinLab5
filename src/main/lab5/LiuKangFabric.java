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
public class LiuKangFabric implements EnemyFabric {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new LiuKang(1, 70, 20, 1);
        return enemy;
    }
}
