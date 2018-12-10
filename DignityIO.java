import java.util.*;
import java.io.*;

public class DignityIO
{
   private File file;
   private ArrayList<String> dares = new ArrayList<String>(); //should later be an arraylist of dares
   
   public DignityIO(File f)
   {
      this.file = f;
   }
   
   public void readFile() throws FileNotFoundException //reads the main file
   {
      Scanner console = new Scanner(file);
      while (console.hasNextLine())
      {
         dares.add(console.nextLine());
      }
   }
   
   public String toString() //prints all of the dares with square brackets and commas
   {
      String print = "[" + dares.get(0);
      for (int i = 1; i < dares.size(); i++)
      {
         print += (", " + dares.get(i));
      }
      return print + "]";
   }
   
   public static void main(String[] args) throws FileNotFoundException //client testing
   {
      DignityIO oof = new DignityIO(new File("dares.txt"));
      oof.readFile();
      System.out.println(oof);
   }
}
