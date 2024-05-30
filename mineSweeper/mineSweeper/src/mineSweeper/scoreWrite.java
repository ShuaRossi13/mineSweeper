package mineSweeper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class scoreWrite extends ClickLogic{
    private static File ratio = new File("Assets/text/ratio.csv");
    protected static void write(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ratio))){
            writer.write(wins + "," + losses);
        }catch (IOException e) {
            System.err.println("IOException");
        }
    }
}
