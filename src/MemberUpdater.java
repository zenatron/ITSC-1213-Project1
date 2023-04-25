import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberUpdater {

    public static String toCSV(ArrayList<Member> memberList)
    {
        String content = "";
        for (Member member : memberList)
        {
            content += member.getFirstName() + ",";
            content += member.getLastName() + ",";
            content += member.getId() + ",";
            content += member.getTotalSpent() + ",";
            content += (member instanceof PremiumMember) + "\n";
        }
        return content;
    }

    public static void saveMembers(ArrayList<Member> memberList) {
        String newFilename = "members.csv";

        try {
            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Writes the header text
            printWriter.println("First,Last,ID,TotalSpent,Premium");

            printWriter.println(toCSV(memberList));

            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

