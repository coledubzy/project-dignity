import java.util.*;
import java.io.*;

public class DignityIO
{
   private File file;
   private ArrayList<String> dares = new ArrayList<String>();
   
   public DignityIO(File f)
   {
      this.file = f;
   }
   
   public void readFile() throws FileNotFoundException
   {
      Scanner console = new Scanner(file);
      while (console.hasNextLine())
      {
         dares.add(console.nextLine());
      }
   }
   
   public String toString()
   {
      String print = "[" + dares.get(0);
      for (int i = 1; i < dares.size(); i++)
      {
         print += (", " + dares.get(i));
      }
      return print + "]";
   }
   
   public static void main(String[] args) throws FileNotFoundException
   {
      DignityIO oof = new DignityIO(new File("dares.txt"));
      oof.readFile();
      System.out.println(oof);
   }
}