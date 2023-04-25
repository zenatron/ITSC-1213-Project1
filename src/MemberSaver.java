import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberSaver {

    public static void saveMembers(ArrayList<Member> memberList) {
        String newFilename = "members.csv";

        try {
            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Writes the header text
            printWriter.write("First,Last,ID,TotalSpent,Premium");

            for (Member member : memberList) {
                printWriter.write("\n");
                printWriter.write(member.getFirstName() + "," + member.getLastName() + "," + member.getId() + "," + member.getTotalSpent() + "," + (member instanceof PremiumMember));
            }

            fileWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

