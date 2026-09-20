public class CSVRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.printf("Name: %s | Roll No: %s | Dept: %s\n",
                    fields[0].trim(), fields[1].trim(), fields[2].trim());
        }
    }
    
    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}