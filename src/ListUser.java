import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 public class ListUser {

    public static void readAndWriteListUser(String nameFile) {
        int count =0;
        try (FileReader read = new FileReader(nameFile)){
            BufferedReader readers = new BufferedReader(read);
            String lines;
            //System.out.println(lines);
            while ((lines = readers.readLine()) != null) {
                count++;
            }
            //System.out.println(count);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileReader read = new FileReader(nameFile)){
            BufferedReader reader = new BufferedReader(read);

            String coma = ",";
            String name = "\"name\"";
            String nameName = "";
            String age = "\"age\"";
            String ageAge = "";
            reader.readLine();
            int countLine =0;

            String line = reader.readLine();
            String inputWrite = "";
            ValidNumber.writeFile("user.json","[");
             while ( line != null){
                 countLine++;
                 line = line.strip();
                 line = line.replaceAll("\\s+"," ");
                 int j = line.indexOf(' ');
                for (int i = 0; i < j; i++) {
                     nameName = nameName + line.charAt(i);
                 }

                 ageAge = line.substring(j,line.length());
                if (countLine == count-1) {
                    coma = "";
                }

                    inputWrite = inputWrite + "\n    {\n        \"name\": " + "\"" + nameName +"\",\n";
                    inputWrite = inputWrite + "        \"age\":" + ageAge + "\n    }" + coma;
                 ValidNumber.writeFile("user.json",inputWrite);
                 //System.out.println(line);
                 //System.out.println(nameName);
                 //System.out.println(ageAge);
                 line = reader.readLine();
                    inputWrite = "";
                    nameName = "";
                    ageAge = "";
            }
            ValidNumber.writeFile("user.json","\n]");
            // Main.writeFile("user.json",ageAge);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        ValidNumber.writeFileWithOutputStream("file.txt","name age\njon     25\nryan     30\n   alice    21\nmykola 33\n");
        new FileWriter("user.json", false).close();
         ListUser.readAndWriteListUser("file.txt");
    }
}

