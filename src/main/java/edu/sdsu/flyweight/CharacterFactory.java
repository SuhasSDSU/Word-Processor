package edu.sdsu.flyweight;

import java.util.HashMap;
import java.util.Map;

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
