package don.test.framework.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.util.HashMap;

public class CapabilitiesReader {
    private static String jsonInfo = "src/test/resources/capability_info.json";
    public static JSONArray parseJSON(String jsonLocation) throws Exception {
        System.out.println("parseJSON starts");
        JSONParser jsonParser = new JSONParser();

        return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
    }

    public static JSONObject getCapability(String capabilityName, String jsonLocation) throws Exception {
        System.out.println("getCapability starts");
        JSONArray capabilitiesArray = parseJSON(jsonLocation);

        for(Object jsonObj : capabilitiesArray) {
            JSONObject capability = (JSONObject) jsonObj;
            if(capability.get("name").toString().equalsIgnoreCase(capabilityName)){
                return (JSONObject) capability.get("caps");
            }
        }
        System.out.println("동일한 단말이 존재하지 않습니다. 단말 기종을 다시 확인해주세요.");
        return null;
    }

    public static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("convertCapsToHashMap starts");
        return objectMapper.readValue(getCapability(capabilityName, jsonLocation).toString(), HashMap.class);

    }

    /* DesiredCapability 객체 생성 */
    public static DesiredCapabilities getDesiredCapabilities(String capabilityName) throws Exception {
        System.out.println("getDesiredCapabilities starts");
        HashMap<String, Object> caps = convertCapsToHashMap(capabilityName, CapabilitiesReader.jsonInfo);

        for(String strKey : caps.keySet()) {
            String strValue = caps.get(strKey).toString();
            System.out.println("HashMap print : "+ strKey + "-" + strValue);
        }
        System.out.println("getDesiredCapabilities ends");

        return new DesiredCapabilities(caps);
    }
}
