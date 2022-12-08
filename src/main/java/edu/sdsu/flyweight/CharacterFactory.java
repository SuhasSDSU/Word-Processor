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
   private static CharacterFactory characterFactory;

   private CharacterFactory(){}

  public TextCharacter getFlyWeightCharacter(Character unicode){
     TextCharacter character = characterMap.get(unicode);
     if(character == null){
        character = new TextCharacter(unicode);
        characterMap.put(unicode,character);
     }
     return character;
  }
   public static CharacterFactory getCharacterFactoryInstance(){
      if(characterFactory == null)
         characterFactory = new CharacterFactory();
      return characterFactory;
   }
}
