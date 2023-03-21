package GUI;

import Model.ResponseModel;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class GUITM1 extends JFrame {
    private JButton Submit;
    private JTextField tfmessage;
    private JTextField tfstatus;
    private JTextField tfcomment;
    private JButton closeButton;
    private JPanel MainGUI;
    private JTextField tfjum1;
    private JButton button1;
    private JTextField tfjum2;
    private JTextField tfjum3;
    private JTextPane tpmessage;

    public GUITM1() throws IOException {

        //menentukan tampilan window
        setContentPane(MainGUI);
        setSize(900, 600);
        setVisible(true);
        setUndecorated(true);
        //menghubungkan ke server

        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        //menangkap response

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responsemodel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setMassage(myJSONObject.getString("message"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComment(myJSONObject.getString("comment"));
            responsemodel.add(resModel);
        }
        //button close

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //button submit

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ResponseModel isi : responsemodel) {

                    //menampilkan isi teksbok
                    tfmessage.setText(isi.getMassage());
                    tfstatus.setText(isi.getStatus());
                    tfcomment.setText(isi.getComment());


                    //menghitung angka pada setiap teksbox
                    String[] words = isi.getMassage().split("\\s");
                    int numword = words.length;
                    tfjum1.setText("" + numword);

                    String[] words1 = isi.getStatus().split("\\s");
                    int numword1 = words1.length;
                    tfjum2.setText("" + numword1);

                    String[] words2 = isi.getComment().split("\\s");
                    int numword2 = words2.length;
                    tfjum3.setText("" + numword2);
                }
            }
        });

        //button minimize
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });
    }

    //main
    public static void main(String[] args) throws IOException {
        GUITM1 myFrame = new GUITM1();
    }
}