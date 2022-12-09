package edu.sdsu;

import edu.sdsu.docprocessor.RunArray;
import edu.sdsu.flyweight.FontFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;

public class TextEditorTest {
   @Test
   @DisplayName("Test Font Information in the Run Array")
   public void shouldBeTimesNewRoman(){
      FontFactory factoryInstance = FontFactory.getFontFactoryInstance();
      Font times_new_roman = factoryInstance.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
      Font arial = factoryInstance.getFont("ARIAL",Font.BOLD,12);

      RunArray test = new RunArray();
      test.addRun(0, 3,times_new_roman);
      test.addRun(4, 3,arial);


      test.appendRun(15, times_new_roman);

      Font actualValue = test.getFont(20);
      assertEquals(times_new_roman, actualValue);
   }

   @Test
   @DisplayName("Memory Calculations")
   public void checkMemoryConsumption(){

   }
}
