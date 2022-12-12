package edu.sdsu.FontTest;

import edu.sdsu.docprocessor.RunArray;
import edu.sdsu.flyweight.FontFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;

public class FontTest {
   FontFactory factoryInstance;
   Font timesNewRoman;
   Font arial;
   @BeforeEach
   public void init(){
      factoryInstance = FontFactory.getFontFactoryInstance();
      timesNewRoman = factoryInstance.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
      arial= factoryInstance.getFont("ARIAL",Font.BOLD,12);
   }
   @Test
   @DisplayName("Test Run Array and Font Information in the Run Array")
   public void shouldBeTimesNewRoman(){
      RunArray test = new RunArray();
      test.addRun(0, 3, timesNewRoman);
      test.addRun(4, 3,arial);
      test.appendRun(15, timesNewRoman);
      Font actualValue = test.getFont(20);
      assertEquals(timesNewRoman, actualValue);
   }
   @Test
   @DisplayName("Check the instance of the font factory")
   public void shouldHaveSameInstance(){
      FontFactory actualFontFactory = FontFactory.getFontFactoryInstance();
      FontFactory expectedFontFactory = FontFactory.getFontFactoryInstance();
      assertEquals(expectedFontFactory,actualFontFactory);
   }
}
