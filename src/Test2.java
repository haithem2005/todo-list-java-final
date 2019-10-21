// Java program to create a file "friendsContact.txt"
// and add a new contact in the file

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class AddTask {

    public static void main(String data[])
    {

        try {

            // Get the name of the contact to be updated
            // from the Command line argument
            String newTitle = data[0];


            // Get the number to be updated
            // from the Command line argument
            String newProject = data[1];

            String titleProjectString;
            String title;
            String project;
            int index;

            // Using file pointer creating the file.
            File file = new File("src/test2.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf
                    = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                    // reading line from the file.
                    titleProjectString = raf.readLine();

                // finding the position of '!'
                index = titleProjectString.indexOf('!');

                // separating name and number.
                title = titleProjectString.substring(0, index);
                project = titleProjectString.substring(index + 1);

                // if condition to find existence of record.
                if (title == newTitle || project == newProject) {
                    found = true;
                    break;
                }
            }

            if (found == false) {

                // Enter the if block when a record
                // is not already present in the file.
                titleProjectString = newTitle + "!" + newProject;

                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(titleProjectString);

                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());

                // Print the message
                System.out.println(" Task added ");

                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Print the message
                System.out.println(" Input name"
                        + " does not exists. ");
            }
        }

        catch (IOException ioe) {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {

            System.out.println(nef);
        }
    }
}
