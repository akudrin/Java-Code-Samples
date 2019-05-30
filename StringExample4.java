public class StringExample4 {

 public static void main(String[] args) {

  //Replacing All Text Matches
  String str = "I love Java 8! It is my favorite language. Java 8
  is the " +
  "8th version of this great programming language.";
  Pattern pattern = Pattern.compile("[0-9]");
  Matcher matcher = pattern.matcher(str);
  System.out.println("Original: " + str);
  System.out.println(matcher.matches());
  System.out.println("Replacement: " + matcher.replaceAll("9"));

  //Determining Whether a File Suffix Matches a Given String
  if (filename.endsWith(".txt")) {
   System.out.println("Text file");
  } else if (filename.endsWith(".doc")) {
   System.out.println("Document file");
  } else if (filename.endsWith(".xls")) {
   System.out.println("Excel file");
  } else if (filename.endsWith(".java")) {
   System.out.println("Java source file");
  } else {
   System.out.println("Other type of file");
  }

 }

}
