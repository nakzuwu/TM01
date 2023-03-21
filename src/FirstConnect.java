import Model.ResponseModel;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya= new ConnectURI();
        URL myAddress= koneksisaya.buildURL
                ("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responsemodel= new ArrayList<>();
        for(int i=0;i<responseJSON.length();i++){
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setMassage(myJSONObject.getString("message"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComment(myJSONObject.getString("comment"));
            responsemodel.add(resModel);
        }
        System.out.println("Response are :");
        for(int index=0;index< responsemodel.size();index++){
            System.out.println("MESSAGE : "+responsemodel.get(index).getMassage());
            System.out.println("STATUS : "+responsemodel.get(index).getStatus());
            System.out.println("COMMENT : "+responsemodel.get(index).getComment());

        }

    }
}