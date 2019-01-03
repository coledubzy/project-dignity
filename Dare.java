public class Dare {

   private int value;
   private String text;
   
   public Dare() { //Sample Comment
      this.value = 0;
      this.text = "null";
   }
   
   public Dare(int value, String text) {
      this.value = value;
      this.text = text;
   }
   
   public int getValue() {
      return this.value;
   }
   
   public String getText() {
      return this.text;
   }
   
   public void setValue(int value) {
      this.value = value;
   }
   
   public void setText(String text) {
      this.text = text;
   }
}
