package edu.sdsu.util;

import edu.sdsu.docprocessor.CharacterAndFont;
import edu.sdsu.flyweight.CharacterFactory;
import edu.sdsu.flyweight.FontFactory;
import edu.sdsu.flyweight.TextCharacter;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
public class SizeCalculator {
   private static String text = "CS 635 Advanced Object-Oriented Design & Programming\n" +
         "Fall Semester, 2018\n" +
         "Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" +
         "Nov 19, 2019\n" +
         "Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San\n" +
         "Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license de-\n" +
         "fines the copyright on this document.";
   final static char[] textArray = text.toCharArray();
   public static void main(String[] args) {
      getFontSize();
      getCharacterFontSize();
      getCharacterFactorySize();
      getFlyweightListSize();
   }
   /**
    * Using this to get memory consumption by CharacterAndFont
    */
   public static int getCharacterFontSize(){
      int characterFontSize = (int) new SizeCalculation() {
         List<Character> characterList = null;
         @Override
         protected int create() {
            characterList = new ArrayList<>();
            for (char c : textArray) {
               characterList.add(c);
            }
            return 1;
         }
      }.averageBytes();
      System.out.println(characterFontSize);
      return characterFontSize;
   }

   /**
    * Using this to get memory consumption by CharacterAndFont
    */
   public static int getFontSize(){
      int fontSize = (int) new SizeCalculation() {
         CharacterAndFont arial = null;
         @Override
         protected int create() {
            arial = new CharacterAndFont('T', new Font("Arial", Font.BOLD, 12));
            return 1;
         }
      }.averageBytes();
      System.out.println("fontsize"+fontSize);
      return fontSize;
   }

   /**
    * Using this to get memory consumption by flyweight
    */
   public static int getCharacterFactorySize(){
      int characterFactorySize = (int) new SizeCalculation(){
         FontFactory fontFactory = null;
         CharacterFactory characterFactory = null;
         List<TextCharacter> characterList = null;
         @Override
         protected int create() {
            Font timesNewRoman = new Font("TIMES NEW ROMAN", Font.ITALIC, 10);
            characterList = new ArrayList<>();
            TextCharacter character = new TextCharacter('a');
            return 1;
         }
      }.averageBytes();
      System.out.println("characterFactory size"+characterFactorySize);
      return characterFactorySize;
   }

   /**
    * Used in the fly-weight testing
    * @return
    */
   public static int getFlyweightListSize(){
   List<TextCharacter> characterList = null;
      characterList = new ArrayList<>();
      for (int i = 0; i < textArray.length; i++) {
         CharacterFactory characterFactory = CharacterFactory.getCharacterFactoryInstance();
         TextCharacter flyWeightCharacter = characterFactory.getFlyWeightCharacter(textArray[i]); //unicode
         // need this avoid creation of new reference in the list pointing to same static flyweight character
         if (!characterList.contains(flyWeightCharacter)) {
            characterList.add(flyWeightCharacter);
         }
      }
      return characterList.size();
   }

   /**
    * Used to calculate the list size without using flyweight
    * @return
    */
   public static int getListSize(){
      List<TextCharacter> characterList = null;
      characterList = new ArrayList<>();
      for (int i = 0; i < textArray.length; i++) {
         CharacterFactory characterFactory = CharacterFactory.getCharacterFactoryInstance();
         TextCharacter flyWeightCharacter = characterFactory.getFlyWeightCharacter(textArray[i]); //unicode
         characterList.add(flyWeightCharacter);
      }
      return characterList.size();
   }
}
