import java.util.*;
import java.io.*;

public class DignityIO
{
   private File file;
   private ArrayList<Dare> dares = new ArrayList<Dare>();
   
   public DignityIO(File f)
   {
      this.file = f;
   }
   
   public void readFile() throws FileNotFoundException
   {
      Scanner console = new Scanner(file);
      while (console.hasNextLine())
      {
         dares.add(new Dare(Integer.parseInt(console.nextLine()), console.nextLine()));
      }
   }
   
   public String toString()
   {
      String print = "[" + dares.get(0).getText();
      for (int i = 1; i < dares.size(); i++)
      {
         print += (", " + dares.get(i).getText());
      }
      return print + "]";
   }
   
   public ArrayList<Dare> getList()
   {
      return this.dares;
   }
   
   public static void main(String[] args) throws FileNotFoundException
   {
      DignityIO oof = new DignityIO(new File("dares.txt"));
      oof.readFile();
      System.out.println(oof);
   }
}