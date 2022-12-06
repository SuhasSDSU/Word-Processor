package edu.sdsu.flyweight;

import java.awt.*;


/*
*
* For the Character Flyweight to work we need to a way to story
* the extrinsic state of the character objects, that is the font information.
*
* So this is UnSharedConcreteFlyweight as it has extrinsic state
 * */
public class FontInfo {
   private int startIndex;
   private int endIndex;
   Font characterFont;

   public FontInfo(int startIndex, int endIndex, Font characterFont){
      this.characterFont = characterFont;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
   }
}
