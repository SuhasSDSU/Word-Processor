package edu.sdsu.textEditor;

import edu.sdsu.docprocessor.RunArray;
import edu.sdsu.flyweight.CharacterFactory;
import edu.sdsu.flyweight.FontFactory;
import edu.sdsu.flyweight.TextCharacter;
import edu.sdsu.util.SizeCalculation;

import java.awt.*;
import java.util.ArrayList;

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


         ArrayList<TextCharacter> characterList = null;
         final char[] textArray = text.toCharArray();

         @Override
         protected int create() {
            characterList = new ArrayList<TextCharacter>();

            FontFactory aFontFactory = FontFactory.getFontFactoryInstance();
            Font fontOne = aFontFactory.getFont("TIMES NEW ROMAN", Font.ITALIC, 10);
            Font fontTwo = aFontFactory.getFont("ARIAL", Font.BOLD, 12);

            RunArray runArray = new RunArray();
            runArray.addRun(0, 115, fontOne); // 0 -- 114
            runArray.addRun(115, 211, fontTwo); // 114- 325


            for (int i = 0; i < textArray.length; i++) {
               CharacterFactory aTextCharacterFactory = CharacterFactory.getCharacterFactoryInstance();
               TextCharacter aTextCharacter = aTextCharacterFactory.getFlyWeightCharacter(textArray[i]); //unicode
               if (!characterList.contains(aTextCharacter))
                  characterList.add(aTextCharacter);
            }
            return 1;
         }
      }.averageBytes());

   }
}