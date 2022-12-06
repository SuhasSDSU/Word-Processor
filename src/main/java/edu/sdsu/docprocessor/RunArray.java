package edu.sdsu.docprocessor;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RunArray {

   // this would list type should change later on
   private List<String> stringList;

   public RunArray(){
      this.stringList = new ArrayList<>();
   }
   void addRun(int startIndex, int run, Font font){
      for(int i = startIndex; i < run; i++ ){
         this.stringList.add("Test");
      }
   }
   void appendRun(int run, Font font ){}
}
