package edu.sdsu.flyweightTest;

import edu.sdsu.docprocessor.RunArray;
import edu.sdsu.flyweight.CharacterFactory;
import edu.sdsu.flyweight.FontFactory;
import edu.sdsu.flyweight.TextCharacter;
import edu.sdsu.util.SizeCalculation;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class FlyWeightTextEditor {
   public static void main(String args[]) {

      System.out.println("~~~~~~~~~~~~~~~With Flyweight~~~~~~~~~~~~~~~");

      System.out.printf("The average size of TotalSize is %.1f bytes%n", new SizeCalculation() {

         final String text = "CS 635 Advanced Object-Oriented Design & Programming\n" +
               "Fall Semester, 2018\n" +
               "Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" +
               "Nov 19, 2019\n" +
               "Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San\n" +
               "Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license de-\n" +
               "fines the copyright on this document.";


         List<TextCharacter> characterList = null;
         final char[] textArray = text.toCharArray();

         @Override
         protected int create() {
            characterList = new ArrayList<>();

            FontFactory fontFactory = FontFactory.getFontFactoryInstance();
            Font timesNewRoman = fontFactory.getFont("TIMES NEW ROMAN", Font.ITALIC, 10);
            Font arial = fontFactory.getFont("ARIAL", Font.BOLD, 12);

            RunArray runArray = new RunArray();
            runArray.addRun(0, 115, timesNewRoman); // 0 -- 114
            runArray.addRun(115, 211, arial); // 114- 325


            for (int i = 0; i < textArray.length; i++) {
               CharacterFactory characterFactory = CharacterFactory.getCharacterFactoryInstance();
               TextCharacter flyWeightCharacter = characterFactory.getFlyWeightCharacter(textArray[i]); //unicode
               if (!characterList.contains(flyWeightCharacter))
                  characterList.add(flyWeightCharacter);
            }
            return 1;
         }
      }.averageBytes());

   }
}
