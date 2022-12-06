package edu.sdsu.flyweight;

import java.util.HashMap;
import java.util.Map;

/*
* You need a Flyweight factory that
* given a unicode code point (a char in Java) returns
* the Flyweight character object for the character
* */
public class CharacterFactory {
   private Map<Character, TextCharacter> characterMap = new HashMap<>();
   private static CharacterFactory aTextCharacterFactory;

   private CharacterFactory(){}

  public TextCharacter getFlyWeightCharacter(Character unicode){
     TextCharacter aTextCharacter = characterMap.get(unicode);
     if(aTextCharacter == null){
        aTextCharacter = new TextCharacter(unicode);
        characterMap.put(unicode,aTextCharacter);
     }
     return aTextCharacter;
  }
   public static CharacterFactory getCharacterFactoryInstance(){
      if(aTextCharacterFactory == null)
         aTextCharacterFactory = new CharacterFactory();
      return aTextCharacterFactory;
   }
}
