import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> transformDateFormat(List<String> dates) {
        List<String> transformedDates = new ArrayList<>();
        String year,month,day;
        for (String date : dates) {
            if (date.contains("-"))
            {
                String[] parts = date.split("-");
                year = parts[2];
                month = parts[0];
                day = parts[1];
                transformedDates.add(year + month + day);
            } else if (date.contains("/"))
            {
                String[] parts = date.split("/");
                month = parts[1];
                if (parts[0].length() > 2)
                {
                    year = parts[0];
                    day = parts[2];
                }
                else
                {
                    year = parts[2];
                    day = parts[0];
                }
                transformedDates.add(year + month + day);
            }
            else
            {
                transformedDates.add(date);
            }
        }
        return transformedDates;
    }
    public static void main(String[] args) {
        //Some test cases
        List<String> testCase = new ArrayList<>();
        testCase.add("20130720");
        testCase.add("19/12/2016");
        testCase.add("2016/12/19");
        testCase.add("11-18-2012");
        System.out.println("Result: " + transformDateFormat(testCase));
    }
}