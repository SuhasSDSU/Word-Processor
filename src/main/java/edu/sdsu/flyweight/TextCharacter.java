package edu.sdsu.flyweight;

import java.awt.*;

/*
* You will create a Character class that will store only the unicode code point of the character
*
* This becomes shared Concrete Flyweight
* With intrinsic state
* */
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
