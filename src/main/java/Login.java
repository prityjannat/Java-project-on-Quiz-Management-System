import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/main/resources/users.json"));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "salman");
        jsonObject.put("password", "1234");
        jsonObject.put("role", "student");

        jsonArray.add(jsonObject);
        System.out.println(jsonArray);

        FileWriter fw = new FileWriter("./src/main/resources/users.json");
        fw.flush();
        fw.write("\n");
        fw.write(jsonArray.toJSONString());
        fw.close();

    }
}
