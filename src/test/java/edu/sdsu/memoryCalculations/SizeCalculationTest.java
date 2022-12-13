package edu.sdsu.memoryCalculations;

import edu.sdsu.flyweightTest.FlyWeightTextEditorTest;
import edu.sdsu.flyweightTest.NormalTextEditorTest;
import edu.sdsu.util.SizeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeCalculationTest {
//   SizeCalculator
   int characterFontSize;
   int fontSize;
   int flyWeightListSize;
   int normalListSize;
   int characterFactorySize;

   @BeforeEach
   public void init(){
      characterFontSize = SizeCalculator.getCharacterFontSize();
      fontSize = SizeCalculator.getFontSize();
      flyWeightListSize = SizeCalculator.getFlyweightListSize();
      normalListSize = SizeCalculator.getListSize();
      characterFactorySize =  SizeCalculator.getCharacterFactorySize();
   }

   @Test
   @DisplayName("Checking without flyweight")
   public void shouldBeFiftyThousand(){
      int actualValue = (fontSize * normalListSize) + characterFactorySize;
      int expectedValue = NormalTextEditorTest.getMemoryConsumption();
      assertEquals(expectedValue, actualValue);
   }

   @Test
   @DisplayName("Checking with flyweight")
   public void shouldBeTwoThousand(){
      int actualValue = (fontSize * flyWeightListSize) + characterFactorySize;
      int expectedValue = FlyWeightTextEditorTest.getMemoryConsumption();
      assertEquals(expectedValue, actualValue);
   }
}
