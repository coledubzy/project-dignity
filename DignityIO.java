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
      {
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
   
   public DareList getList()
   {
      return this.dares;
   }
   
   public static void main(String[] args) throws FileNotFoundException //testing
   {
      DignityIO oof = new DignityIO(new File("dares.txt"));
      oof.readFile();
      DareList yeouch = new DareList();
      yeouch.addDare(4, "add this dare");
      yeouch.mergeLists(oof.getList());
      System.out.println(oof);
      System.out.println(oof.getList().getSize());
      System.out.println(yeouch);
   }
}