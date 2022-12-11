package edu.sdsu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Font;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeCalculationTest {
      @Test()
      @DisplayName("Test")
      public void avgBytesString() throws Exception {
         System.out.printf("The average size of an int is %.1f bytes%n", new SizeCalculation() {
            Object obj = null;
            @Override
            protected int create() {
               obj = new Object();
               return 1;
            }
         }.averageBytes());
      }

   public void avgBytesFont() throws Exception {
      System.out.printf("The average size of an int is %.1f bytes%n", new SizeCalculation() {
         Font font = null;
         @Override
         protected int create() {
            font = new Font("Arial", Font.BOLD, 12);
            return 1;
         }
      }.averageBytes());
   }

}
