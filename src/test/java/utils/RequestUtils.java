package utils;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils
{
    public static Map<String,String> setHeader(String token, String tenantId) {

        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("tenant", tenantId);

        return headers;

    }

}
