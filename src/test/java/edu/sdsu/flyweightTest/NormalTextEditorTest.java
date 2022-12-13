package edu.sdsu.flyweightTest;

import edu.sdsu.docprocessor.CharacterAndFont;
import edu.sdsu.util.SizeCalculation;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class NormalTextEditorTest {
   public static int getMemoryConsumption(){

      System.out.println("~~~~~~~~~~~~~~~Without Flyweight~~~~~~~~~~~~~~~");
      int textEditorSize = (int) new SizeCalculation() {
         final String text = "CS 635 Advanced Object-Oriented Design & Programming\n" +
               "Fall Semester, 2018\n" +
               "Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" +
               "Nov 19, 2019\n" +
               "Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San\n" +
               "Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license de-\n" +
               "fines the copyright on this document.";

         final char[] textArray = text.toCharArray();
         List<CharacterAndFont> characterList = null;
         @Override
         protected int create() {
            characterList = new ArrayList<>();
            for (char c : textArray) {
               Font arial = new Font("Arial", Font.BOLD, 12);
               CharacterAndFont font = new CharacterAndFont(c, arial);
               characterList.add(font);
            }
            return 1;
         }
      }.averageBytes();
      return textEditorSize;
   }

}
