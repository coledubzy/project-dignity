public class Dare { //these will be stored in DareList

   private int value;//the dare's point value
   private String text;//the dare itself
   
   public Dare() { //no argument constructor
      this.value = 0;
      this.text = "null";
   }
   
   public Dare(int value, String text) {//two-argument constructor, what the client will primarily use
      this.value = value;
      this.text = text;
   }
   
   //will return the dare's point vlaue
   public int getValue() {
      return this.value;
   }
   
   //will return the dare as a String
   public String getText() {
      return this.text;
   }
   
   //point value mutator
   public void setValue(int value) {
      this.value = value;
   }
   
   //dare text mutator
   public void setText(String text) {
      this.text = text;
   }
}
