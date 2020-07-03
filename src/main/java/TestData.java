import java.util.ArrayList;

public class TestData {

    static Xls_Reader reader;

    public static ArrayList<Object[]> getData() {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            reader = new Xls_Reader( "C:\\Users\\Admin\\Downloads\\springbootDataApp\\Project\\src\\main\\resources\\Data.xlsx");
            for (int rowNum = 2; rowNum<= reader.getRowCount("TestData"); rowNum++){
                String name = reader.getCellData("TestData","name",rowNum);
                String number = reader.getCellData("TestData","number",rowNum);
                String email = reader.getCellData("TestData","email",rowNum);
                String message = reader.getCellData("TestData","message",rowNum);
                String object[] = {name,number,email,message};
                data.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
