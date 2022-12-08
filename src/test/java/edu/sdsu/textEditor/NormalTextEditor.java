package edu.sdsu.textEditor;

import edu.sdsu.docprocessor.CharacterAndFont;
import edu.sdsu.util.SizeCalculation;

import java.awt.*;
import java.util.ArrayList;

public class NormalTextEditor {
   public static void main(String args[]){

      System.out.println("~~~~~~~~~~~~~~~Without Flyweight~~~~~~~~~~~~~~~");

      System.out.printf("The average size of NormalCharacterWithFont is %.10f bytes%n", new SizeCalculation() {
         /***
          * From Assignment -->
          * CS 635 Advanced Object-Oriented Design & Programming
          * Fall Semester, 2018
          * Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object
          * Nov 19, 2019
          * Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San
          * Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license de-
          * fines the copyright on this document.
          */
         final String text = "CS 635 Advanced Object-Oriented Design & Programming\n" +
               "Fall Semester, 2018\n" +
               "Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" +
               "Nov 19, 2019\n" +
               "Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San\n" +
               "Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license de-\n" +
               "fines the copyright on this document.";

         final char[] textArray = text.toCharArray();

         ArrayList<CharacterAndFont> characterList = null;


         @Override
         protected int create() {
            characterList = new ArrayList<>();
            for (char c : textArray) {
               Font fontA = new Font("Arial", Font.BOLD, 12);
               CharacterAndFont aCharacter = new CharacterAndFont(c, fontA);
               characterList.add(aCharacter);
            }
            return 1;
         }
      }.averageBytes());

   }


}
