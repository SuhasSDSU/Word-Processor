package edu.sdsu.docprocessor;


import edu.sdsu.flyweight.FontInfo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RunArray {
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
      return fontInfos.stream()
            .filter(fontInfo-> fontInfo.contains(index))
            .findFirst()
            .orElse(null).getCharacterFont();
   }
   public void appendRun(int run, Font font ){
      int startIndex = endIndex+1;
      endIndex = (startIndex+run)-1;
      fontInfos.add(new FontInfo(startIndex, endIndex, font));
   }
}
