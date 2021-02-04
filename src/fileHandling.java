import java.io.*;

public class fileHandling {


    public static void main(String[] args) {
        //1. File create a file.
        String path = "C:\\Users\\sahit\\IdeaProjects\\demo\\src\\abc.txt";

        File fl = new File(path);

        /* File class opertions*/
//
////            boolean isCreated = fl.createNewFile();           //=> to create a new file, with given path.
//
//        boolean isAreadyExists = fl.exists();                   //=> to check if a file already exists or not.
//
//        boolean flag1 = fl.isFile();                         //=> to check it given path, correspondes to a file or not.
//        boolean ifItisDirectory = fl.isDirectory();           // if the given path, correspondes to a directory
//        //so on.......
//
//
//        if(isAreadyExists == true) {
//            System.out.println("File is already exist");
//        }
//        else {
//            System.out.println("File not exists");
//        }



        /* Writing a file*/


//        try {
//            boolean isCreated = fl.createNewFile();
//
//            if(isCreated) {
//                System.out.println("created");
//            }
//            else {
//                System.out.println("not created");
//            }
//
//        }
//        catch(IOException e) {
//            System.out.println("error aagaya");
//        }

//
//
//        try {
//            FileWriter fw = new FileWriter(path);
//
//            String str = "";
//
//            fw.write("This is Exception Handing Class");
//
//            fw.close();
//        }
//        catch(IOException e) {
//            System.out.println(e);
//        }



        /*Read a file content*/

        try {
            FileReader fr = new FileReader(path);

            int ch;
            while((ch = fr.read()) != -1) {
                System.out.print((char)ch);
            }

            fr.close();

        }
        catch(IOException e) {
            System.out.println(e);
        }

    }

}
















