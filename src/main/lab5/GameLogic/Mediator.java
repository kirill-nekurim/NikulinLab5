package mortalkombatbversion.src.main.lab5.GameLogic;

import javax.swing.*;
import mortalkombatbversion.src.main.lab5.Inside.Character;
import mortalkombatbversion.src.main.lab5.Inside.Player;
import mortalkombatbversion.src.main.lab5.Inside.Items;
import mortalkombatbversion.src.main.lab5.Actions.Action;
import static mortalkombatbversion.src.main.lab5.Inside.CharacterName.You;
public class Mediator {
    private static final int DIALOG_WIDTH = 600;
    private static final int DIALOG_HEIGHT = 500;
    private static final String ACTION_FORMAT = "%s %s %s";
    private static final String DEBUFF_FORMAT = "%s is debuffed for %d turns";
    private JLabel enemyHealthLabel;
    private JLabel playerHealthLabel;
    private JLabel pointsValueLabel;
    private JLabel experienceValueLabel;
    private JLabel playerLevelLabel;
    private JLabel enemyLevelLabel;
    private JLabel playerDamageValueLabel;
    private JLabel endRoundLabel;
    private JLabel enemyDebuffLabel;
    private JLabel victoryLabel;
    private JLabel endGameWithoutLadderTitlleLabel;
    private JLabel playerActionLabel;
    private JLabel playerDebuffLabel;
    private JLabel enemyActionLabel;
    private JProgressBar playerHealthBar;
    private JProgressBar enemyHealthBar;
    private JDialog endFightDialog;
    private JDialog endGameDialog;
    private JDialog endGameWithoutLadderDialog;
    private JDialog cantUseItemDialog;
    private JFrame fightFrame;
    private JRadioButton firstItemButton;
    private JRadioButton secondItemButton;
    private JRadioButton thirdItemButton;
    public void setActionLabels(Character enemy, Character human, Action enemyAction, Action playerAction) {
        updateLabel(playerActionLabel, human.getStringName(), "uses", playerAction.getType());
        updateLabel(enemyActionLabel, enemy.getStringName(), "use", enemyAction.getType());
    }
    private void updateLabel(JLabel label, String playerName, String action, String actionType) {
        label.setText(String.format(ACTION_FORMAT, playerName, action, actionType));
    }
    public void setDebuffLabel(Character gameCharacter, boolean isDebuffed) {
        String debuffText = isDebuffed ? String.format(DEBUFF_FORMAT, gameCharacter.getName(), gameCharacter.getDebuffTurns()) : "";
        updateDebuffLabel(gameCharacter, debuffText);
    }
    private void updateDebuffLabel(Character gameCharacter, String debuffText) {
        if (gameCharacter.getName().equals(You)) {
            playerDebuffLabel.setText(debuffText);
        } else {
            enemyDebuffLabel.setText(debuffText);
        }
    }
    public void setHealthBar(Character gameCharacter) {
        JProgressBar healthBar = gameCharacter.getName().equals(You) ? playerHealthBar : enemyHealthBar;
        healthBar.setValue(Math.max(gameCharacter.getHealth(), 0));
    }
    public void setPlayerMaxHealthBar(Character human) {
        playerHealthBar.setMaximum(human.getMaxHealth());
    }
    public void setEnemyMaxHealthBar(Character enemy) {
        enemyHealthBar.setMaximum(enemy.getMaxHealth());
    }
    public void revive(Character human, Items[] items) {
        playerHealthLabel.setText(human.getHealth() + "/" + human.getMaxHealth());
        thirdItemButton.setText(items[2].getName() + ", " + items[2].getCount() + " ��");
        playerActionLabel.setText("�� ���������");
    }
    public void gameEnding(String text, boolean isVictory) {
        if (isVictory) {
            endGameDialog.setVisible(true);
            endGameDialog.setBounds(150, 150, DIALOG_WIDTH, DIALOG_HEIGHT);
            victoryLabel.setText(text);
        } else {
            endGameWithoutLadderDialog.setVisible(true);
            endGameWithoutLadderDialog.setBounds(150, 150, DIALOG_WIDTH, DIALOG_HEIGHT);
            endGameWithoutLadderTitlleLabel.setText(text);
        }
        fightFrame.dispose();
    }
    public void makeEndFightDialogVisible() {
        endFightDialog.setVisible(true);
        endFightDialog.setBounds(300, 150, 700, 600);
    }

    public void setRoundEndText(String text) {
        endRoundLabel.setText(text);
    }
    public void openCantUseItemDialog() {
        cantUseItemDialog.setVisible(true);
        cantUseItemDialog.setBounds(300, 200, 400, 300);
    }

    public void setBagText(Items[] items) {
        firstItemButton.setText(items[0].getName() + ", " + items[0].getCount() + " ��");
        secondItemButton.setText(items[1].getName() + ", " + items[1].getCount() + " ��");
        thirdItemButton.setText(items[2].getName() + ", " + items[2].getCount() + " ��");
    }
    public void setRoundTexts(Character human, Character enemy) {
        updateHealthLabel(playerHealthLabel, human);
        updateHealthLabel(enemyHealthLabel, enemy);
    }

    private void updateHealthLabel(JLabel label, Character gameCharacter) {
        if (gameCharacter.getHealth() >= 0) {
            label.setText(gameCharacter.getHealth() + "/" + gameCharacter.getMaxHealth());
        } else {
            label.setText("0/" + gameCharacter.getMaxHealth());
        }
    }
    public void setNewRoundTexts(Character human, Character enemy, Items[] items) {
        playerActionLabel.setText("");
        enemyActionLabel.setText("");
        pointsValueLabel.setText(Integer.toString(((Player) human).getPoints()));
        experienceValueLabel.setText(((Player) human).getExperience() + "/" + ((Player) human).getNextExperience());
        playerLevelLabel.setText((human.getLevel()) + 1 + " level");
        enemyLevelLabel.setText(enemy.getLevel() + " level");
        playerHealthLabel.setText(human.getMaxHealth() + "/" + human.getMaxHealth());
        enemyHealthLabel.setText(enemy.getMaxHealth() + "/" + enemy.getMaxHealth());
        playerDamageValueLabel.setText(Integer.toString(human.getDamage()));
        setBagText(items);
    }
    public void setEnemyHealthLabel(JLabel enemyHealthLabel) {
        this.enemyHealthLabel = enemyHealthLabel;
    }

    public void setPlayerHealthLabel(JLabel playerHealthLabel) {
        this.playerHealthLabel = playerHealthLabel;
    }

    public void setPointsValueLabel(JLabel pointsValueLabel) {
        this.pointsValueLabel = pointsValueLabel;
    }

    public void setExperienceValueLabel(JLabel experienceValueLabel) {
        this.experienceValueLabel = experienceValueLabel;
    }

    public void setPlayerLevelLabel(JLabel playerLevelLabel) {
        this.playerLevelLabel = playerLevelLabel;
    }

    public void setEnemyLevelLabel(JLabel enemyLevelLabel) {
        this.enemyLevelLabel = enemyLevelLabel;
    }

    public void setPlayerDamageValueLabel(JLabel playerDamageValueLabel) {
        this.playerDamageValueLabel = playerDamageValueLabel;
    }

    public void setEndRoundLabel(JLabel endRoundLabel) {
        this.endRoundLabel = endRoundLabel;
    }

    public void setEnemyDebuffLabel(JLabel enemyDebuffLabel) {
        this.enemyDebuffLabel = enemyDebuffLabel;
    }

    public void setVictoryLabel(JLabel victoryLabel) {
        this.victoryLabel = victoryLabel;
    }

    public void setEndGameWithoutLadderTitlleLabel(JLabel endGameWithoutLadderTitlleLabel) {
        this.endGameWithoutLadderTitlleLabel = endGameWithoutLadderTitlleLabel;
    }

    public void setPlayerActionLabel(JLabel playerActionLabel) {
        this.playerActionLabel = playerActionLabel;
    }

    public void setPlayerDebuffLabel(JLabel playerDebuffLabel) {
        this.playerDebuffLabel = playerDebuffLabel;
    }

    public void setEnemyActionLabel(JLabel enemyActionLabel) {
        this.enemyActionLabel = enemyActionLabel;
    }

    public void setPlayerHealthBar(JProgressBar playerHealthBar) {
        this.playerHealthBar = playerHealthBar;
    }

    public void setEnemyHealthBar(JProgressBar enemyHealthBar) {
        this.enemyHealthBar = enemyHealthBar;
    }

    public void setEndFightDialog(JDialog endFightDialog) {
        this.endFightDialog = endFightDialog;
    }

    public void setEndGameDialog(JDialog endGameDialog) {
        this.endGameDialog = endGameDialog;
    }

    public void setEndGameWithoutLadderDialog(JDialog endGameWithoutLadderDialog) {
        this.endGameWithoutLadderDialog = endGameWithoutLadderDialog;
    }

    public void setCantUseItemDialog(JDialog cantUseItemDialog) {
        this.cantUseItemDialog = cantUseItemDialog;
    }

    public void setFightFrame(JFrame fightFrame) {
        this.fightFrame = fightFrame;
    }

    public void setFirstItemButton(JRadioButton firstItemButton) {
        this.firstItemButton = firstItemButton;
    }

    public void setSecondItemButton(JRadioButton secondItemButton) {
        this.secondItemButton = secondItemButton;
    }

    public void setThirdItemButton(JRadioButton thirdItemButton) {
        this.thirdItemButton = thirdItemButton;
    }
}
