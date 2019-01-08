import java.util.*;
import java.io.*;

public class DignityIO
{
   private File file;
   private DareList dares = new DareList();
   
   public DignityIO(File f)
   {
      this.file = f;
   }
   
   public void readFile() throws FileNotFoundException //reads the text file of dares
   {
      Scanner console = new Scanner(file);
      while (console.hasNextLine())
      { //parses for an integer on the next line and then a dare on the next line
         dares.addDare(new Dare(Integer.parseInt(console.nextLine()), console.nextLine())); 
      }
   }
   
   public String toString()
   {
      String print = "[" + dares.toArrayList().get(0).getText();
      for (int i = 1; i < dares.toArrayList().size(); i++)
      {
         print += (", " + dares.toArrayList().get(i).getText());
      }
      return print + "]";
   }
   
   public DareList getList() //returns the list
   {
      return this.dares;
   }
   
   public static void main(String[] args) throws FileNotFoundException //test case
   {
      DignityIO di = new DignityIO(new File("dares.txt"));
      di.readFile();
      DareList dlist = new DareList();
      dlist.addDare(4, "add this dare");
      dlist.mergeLists(di.getList());
      System.out.println(di);
      System.out.println(di.getList().getSize());
      System.out.println(dlist);
   }
}
