package edu.sdsu.flyweight;

import java.awt.*;

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
