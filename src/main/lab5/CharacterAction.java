/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.src.main.lab5;

import mortalkombatbversion.src.main.lab5.Inside.Character;
import mortalkombatbversion.src.main.lab5.Inside.Items;
import mortalkombatbversion.src.main.lab5.Inside.Player;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Мария
 */
public class CharacterAction {

    private final int experience_for_next_level[] = {40, 90, 180, 260, 410, 1000};

    private final int kind_fight[][] = {{1, 0}, {1, 1, 0}, {0, 1, 0}, {1, 1, 1, 1}};

    private Player enemyes[] = new Player[6];

    EnemyFabricFab fabric = new EnemyFabricFab();

    private Player enemyy = null;

    public void setEnemyes() {
        enemyes[0] = fabric.create(0, 0);
        enemyes[1] = fabric.create(1, 0);
        enemyes[2] = fabric.create(2, 0);
        enemyes[3] = fabric.create(3, 0);
        enemyes[4] = fabric.create(4, 0);
        enemyes[5] = fabric.create(4, 0);
    }

    public Player[] getEnemyes() {
        return this.enemyes;
    }

    public Player ChooseEnemy(JLabel label, JLabel label2, JLabel text, JLabel label3) {
        int i = (int) (Math.random() * 4);
        ImageIcon icon1 = null;
        switch (i) {
            case 0:
                enemyy = enemyes[0];
                icon1 = new ImageIcon("C:\\Users\\Мария\\Desktop\\Baraka.jpg");
                label2.setText("Baraka (танк)");
                break;
            case 1:
                enemyy = enemyes[1];
                icon1 = new ImageIcon("C:\\Users\\Мария\\Desktop\\Sub-Zero.jpg");
                label2.setText("Sub-Zero (маг)");
                break;
            case 2:
                enemyy = enemyes[2];
                icon1 = new ImageIcon("C:\\Users\\Мария\\Desktop\\Liu Kang.jpg");
                label2.setText("Liu Kang (боец)");
                break;
            case 3:
                enemyy = enemyes[3];
                icon1 = new ImageIcon("C:\\Users\\Мария\\Desktop\\Sonya Blade.jpg");
                label2.setText("Sonya Blade (солдат)");
                break;
        }
        label.setIcon(icon1);
        text.setText(Integer.toString(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    public Player ChooseBoss(JLabel label, JLabel label2, JLabel text, JLabel label3, int i) {
        ImageIcon icon1 = null;
        icon1 = new ImageIcon("C:\\Users\\Мария\\Desktop\\Shao Kahn.png");
        label2.setText("Shao Kahn (босс)");
        switch (i) {
            case 2:
                enemyy = enemyes[4];
                break;
            case 4:
                enemyy = enemyes[5];
                break;
        }
        label.setIcon(icon1);
        text.setText(Integer.toString(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    public int[] EnemyBehavior(int k1, int k2, int k3, int k4, double i) {
        int arr[] = null;
        if (i < k1 * 0.01) {
            arr = kind_fight[0];
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            arr = kind_fight[1];
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            arr = kind_fight[2];
        }
        if (i >= (k1 + k2 + k3) * 0.01 & i < 1) {
            arr = kind_fight[3];
        }
        return arr;
    }

    public int[] ChooseBehavior(Player enemy, CharacterAction action) {
        int arr[] = null;
        double i = Math.random();
        if (enemy instanceof Baraka) {
            arr = action.EnemyBehavior(15, 15, 60, 10, i);
        }
        if (enemy instanceof SubZero) {
            arr = action.EnemyBehavior(25, 25, 0, 50, i);
        }
        if (enemy instanceof LiuKang) {
            arr = action.EnemyBehavior(13, 13, 10, 64, i);
        }
        if (enemy instanceof SonyaBlade) {
            arr = action.EnemyBehavior(25, 25, 50, 0, i);
        }
        if (enemy instanceof ShaoKahn) {
            arr = action.EnemyBehavior(10, 45, 0, 45, i);
        }
        return arr;
    }

    public void HP(Player player, JProgressBar progress) {

        if (player.getHealth() >= 0) {
            progress.setValue(player.getHealth());
        } else {
            progress.setValue(0);
        }
    }

    public void AddPoints(Character character, Player[] enemyes) {
        switch (character.getLevel()) {
            case 0:
                character.setExperience(20);
                character.setPoints(25 + character.getHealth() / 4);
                break;
            case 1:
                character.setExperience(25);
                character.setPoints(30 + character.getHealth() / 4);
                break;
            case 2:
                character.setExperience(30);
                character.setPoints(35 + character.getHealth() / 4);
                break;
            case 3:
                character.setExperience(40);
                character.setPoints(45 + character.getHealth() / 4);
                break;
            case 4:
                character.setExperience(50);
                character.setPoints(55 + character.getHealth() / 4);
                break;
        }
        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == character.getExperience()) {
                character.setLevel();
                character.setNextExperience(experience_for_next_level[i + 1]);
                NewHealthHuman(character);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], character);
                }
            }
        }
    }

    public void AddPointsBoss(Character character, Player[] enemyes) {
        switch (character.getLevel()) {
            case 2:
                character.setExperience(30);
                character.setPoints(45 + character.getHealth() / 2);
                break;
            case 4:
                character.setExperience(50);
                character.setPoints(65 + character.getHealth() / 2);
                break;
        }
        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == character.getExperience()) {
                character.setLevel();
                character.setNextExperience(experience_for_next_level[i + 1]);
                NewHealthHuman(character);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], character);
                }
            }
        }
    }

    public void AddItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    public void NewHealthHuman(Character character) {
        int hp = 0;
        int damage = 0;
        switch (character.getLevel()) {
            case 1:
                hp = 25;
                damage = 3;
                break;
            case 2:
                hp = 30;
                damage = 3;
                break;
            case 3:
                hp = 30;
                damage = 4;
                break;
            case 4:
                hp = 40;
                damage = 6;
                break;
        }
        character.setMaxHealth(hp);
        character.setDamage(damage);
    }

    public void NewHealthEnemy(Player enemy, Character character) {
        int hp = 0;
        int damage = 0;
        switch (character.getLevel()) {
            case 1:
                hp = 32;
                damage = 25;
                break;
            case 2:
                hp = 30;
                damage = 20;
                break;
            case 3:
                hp = 23;
                damage = 24;
                break;
            case 4:
                hp = 25;
                damage = 26;
                break;
        }
        enemy.setMaxHealth((int) enemy.getMaxHealth() * hp / 100);
        enemy.setDamage((int) enemy.getDamage() * damage / 100);
        enemy.setLevel();
    }

    public void UseItem(Player human, Items[] items, String name, JDialog dialog, JDialog dialog1) {
        switch (name) {
            case "jRadioButton1":
                if (items[0].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton2":
                if (items[1].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton3":
                dialog.setVisible(true);
                dialog.setBounds(300, 200, 400, 300);
                break;
        }
        
        if(dialog.isVisible()==false){
            dialog1.dispose();
        }
    }
}
