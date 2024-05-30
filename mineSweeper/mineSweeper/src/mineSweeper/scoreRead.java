package mineSweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scoreRead extends MinesweeperApp{
    private static File ratio = new File("Assets/text/ratio.csv");
    protected static int win;
    protected static int loss;
    public static void score() {
        try (Scanner scanner = new Scanner(ratio)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String input = io(line);
                if(input != null){
                    io(line);
                }
            }
        }catch (NullPointerException e){
            winLbl.setText("NullPointerException on winLbl");
            lossLbl.setText("NullPointerException on lossLbl");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String io(String line){
        String[] winLoss = line.split(",");
        try{
            win = Integer.parseInt(winLoss[0]);
            loss = Integer.parseInt(winLoss[1]);
            winLbl.setText("Wins: " + win);
            lossLbl.setText("Losses: " + loss);
            return "";
        }catch (NumberFormatException e){
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
}
