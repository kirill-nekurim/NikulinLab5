package mortalkombatbversion.src.main.lab5.GameLogic;

import mortalkombatbversion.src.main.lab5.GameLogic.Fight;
import mortalkombatbversion.src.main.lab5.GameLogic.Logic;
import mortalkombatbversion.src.main.lab5.GameLogic.Mediator;
import mortalkombatbversion.src.main.lab5.Inside.*;
import mortalkombatbversion.src.main.lab5.Inside.Character;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static mortalkombatbversion.src.main.lab5.Inside.CharacterName.*;

public class Helper {
    public Logic action = new Logic();
    public Fight fight = new Fight();
    private final ArrayList<GameResults> gameResults = new ArrayList<>();
    private final Character[] enemies = new Character[5];

    EnemyFabric fabric = new EnemyFabric();

    public void setEnemies() {
        enemies[0] = fabric.create(BARAKA);
        enemies[1] = fabric.create(SUB_ZERO);
        enemies[2] = fabric.create(LIU_KANG);
        enemies[3] = fabric.create(SONYA_BLADE);
        enemies[4] = fabric.create(SHAO_KAHN);
    }

    public Character[] getEnemies() {
        return this.enemies;
    }

    public Player newHuman(Mediator mediator, Items[] items) {
        Player player = new Player(0, 80, 16, You);
        mediator.setHealthBar(player);
        mediator.setPlayerMaxHealthBar(player);
        player.setItems(items);
        return player;
    }

    public void endGameTop(Player player, JTextField text, JTable table) throws IOException {
        gameResults.add(new GameResults(text.getText(), player.getPoints()));
        gameResults.sort(Comparator.comparing(GameResults::getPoints).reversed());
        writeToTable(table);
        writeToExcel();
    }

    public void writeToExcel() throws IOException {
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            XSSFSheet sheet = book.createSheet("���������� ��� 10");
            XSSFRow r = sheet.createRow(0);
            r.createCell(0).setCellValue("�");
            r.createCell(1).setCellValue("���");
            r.createCell(2).setCellValue("���������� ������");
            for (int i = 0; i < gameResults.size(); i++) {
                if (i < 10) {
                    XSSFRow r2 = sheet.createRow(i + 1);
                    r2.createCell(0).setCellValue(i + 1);
                    r2.createCell(1).setCellValue(gameResults.get(i).getName());
                    r2.createCell(2).setCellValue(gameResults.get(i).getPoints());
                }
            }
            File file = new File(System.getProperty("java.class.path"));
            File dir = file.getAbsoluteFile().getParentFile();
            String path = dir.toString();
            File f = new File(path +"/"+ "Results.xlsx");
            book.write(new FileOutputStream(f));
        }
    }

    public ArrayList<GameResults> getResults() {
        return this.gameResults;
    }

    public void readFromExcel() throws IOException {
        File file = new File(System.getProperty("java.class.path"));
        File dir = file.getAbsoluteFile().getParentFile();
        String path = dir.toString();
        XSSFWorkbook book = new XSSFWorkbook(path +"/"+ "Results.xlsx");
        XSSFSheet sh = book.getSheetAt(0);
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            gameResults.add(new GameResults(sh.getRow(i).getCell(1).getStringCellValue(), (int) sh.getRow(i).getCell(2).getNumericCellValue()));
        }
    }

    public void writeToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < gameResults.size(); i++) {
            if (i < 10) {
                model.setValueAt(gameResults.get(i).getName(), i, 0);
                model.setValueAt(gameResults.get(i).getPoints(), i, 1);
            }
        }
    }
}
