import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ThePerfectTeam {
  /*
     * Method : differentTeams()
     * Param : String 
     * ex. : "pcmbzpcmbz"
     */
    static int differentTeams(String skills) {
        char[] subjectList = {'p', 'c', 'm', 'b', 'z'};
        
        boolean flag = true;
        int maxGroupCount = 0;
        int skilledGroupCount = 0;
        
        HashMap<Character, Integer> skillToStudentMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i < subjectList.length-1; i++) {
            skillToStudentMap.put(subjectList[i], 0);
        }
        
        for(int j = 0; j < skills.length() - 1; j++) {
            char subject = skills.charAt(j);
            if(skillToStudentMap.containsKey(subject)) {
                skillToStudentMap.put(subject, Integer.valueOf(skillToStudentMap.get(subject)) + 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : skillToStudentMap.entrySet()) {
            char key = entry.getKey();
            
            int value = entry.getValue();
            
            if(maxGroupCount > value) {
                maxGroupCount = value;
                skilledGroupCount = value;
            } else if(flag) {
                maxGroupCount = value;
                skilledGroupCount = value;
                flag = false;
            }
            
            if(value == 0) {
                return 0;
            } else if(value <= maxGroupCount) {
                skilledGroupCount = value;
            }
        }
               
        return skilledGroupCount;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        String skills;
        try {
            skills = in.nextLine();
        } catch (Exception e) {
            skills = null;
        }

        res = differentTeams(skills);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}

