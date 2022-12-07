package edu.sdsu.docprocessor;


import edu.sdsu.flyweight.FontInfo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunArray {

   // this would list type should change later on
   private List<FontInfo> fontInfos;
   private int endIndex;

   public RunArray(){
      this.fontInfos = new ArrayList<>();
   }
   public void addRun(int startIndex, int run, Font font){
      endIndex = (run + startIndex) - 1;
      fontInfos.add(new FontInfo(startIndex, endIndex, font));
   }

   public Font getFont(int index){
      Iterator<FontInfo> iterator = fontInfos.iterator();
      while(iterator.hasNext()){
         FontInfo aFontInfo = iterator.next();
         // font found
         if(aFontInfo.contains(index)){
            return aFontInfo.getCharacterFont();
         }
      }
      // no font found
      return null;
   }
   public void appendRun(int run, Font font ){
      int startIndex = endIndex+1;
      endIndex = (startIndex+run)-1;
      fontInfos.add(new FontInfo(startIndex, endIndex, font));
   }
}
