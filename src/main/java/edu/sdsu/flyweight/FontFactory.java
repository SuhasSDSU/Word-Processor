package edu.sdsu.flyweight;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
* Since documents tend to use the same fonts repeatedly we will also use a
* Flyweight factory for fonts. In this factory the input will be a triple:
* the font name (Times, Courier, etc), point size (12, 13, etc) and
* style (bold, italic, underline, etc). This factory also needs a single point of access.=
* */
public class FontFactory {
   private Map<String, Font> cache = new HashMap<>();
   private static FontFactory aFontFactory;
   public Object getFont(String fontName,int fontStyle,int fontSize) {
      if (!cache.containsKey(fontName+fontStyle+fontSize)) {
         cache.put(fontName + fontStyle + fontSize, new Font(fontName, fontStyle, fontSize));
      }
      return cache.get(fontName+fontStyle+fontSize);
   }
   public static FontFactory getFontFactoryInstance(){
      if(aFontFactory == null) aFontFactory = new FontFactory();
      return aFontFactory;
   }
}
