package edu.sdsu.flyweight;

import java.awt.*;

public class FontInfo {
   private int startIndex;
   private int endIndex;
   private Font characterFont;

   public FontInfo(int startIndex, int endIndex, Font characterFont){
      this.characterFont = characterFont;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
   }

   public boolean hasFont(int index){
      return (index >= startIndex && index <= endIndex);
   }

   public Font getCharacterFont() {
      return characterFont;
   }
}
