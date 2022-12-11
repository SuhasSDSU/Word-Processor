package edu.sdsu.flyweight;

import java.awt.*;

public class TextCharacter implements IFlyweight{
   char uniCode;
   public TextCharacter(Character uniCode){
      this.uniCode = uniCode;
   }
   @Override
   public void setFont(Font font) {
      System.out.println("{TextCharacter: "+this+"} {Unicode: "+this.uniCode+"} {Font: "+font+"}");
   }
}
