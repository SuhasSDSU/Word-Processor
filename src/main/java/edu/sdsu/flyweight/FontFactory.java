package edu.sdsu.flyweight;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FontFactory {
   private Map<String, Font> cache = new HashMap<>();
   private static FontFactory fontFactory;
   public Font getFont(String fontName,int fontStyle,int fontSize) {
      if (!cache.containsKey(fontName+fontStyle+fontSize)) {
         cache.put(fontName + fontStyle + fontSize, new Font(fontName, fontStyle, fontSize));
      }
      return cache.get(fontName+fontStyle+fontSize);
   }
   public static FontFactory getFontFactoryInstance(){
      if(fontFactory == null) fontFactory = new FontFactory();
      return fontFactory;
   }
}
