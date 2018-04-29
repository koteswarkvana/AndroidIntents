package com.koti.apple.androidintents;

import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import static com.koti.apple.androidintents.MainActivity.getValue;

//import static com.koti.apple.androidintents.MainActivity.getValue;

/**
 * Created by apple on 18/11/17.
 */

public class ReadJsonFile {
    private static final String TAG = "ReadJsonFile";
    public ReadJsonFile (){
//        try {
//            File file = new File("/sdcard/Android/data/com.adobe.dps.viewer.jupiter/files/cbd49d11-ee71-462a-9840-4dc10e2aacea/manifest.json");
//            File file = new File("/sdcard/Download/Skype/manifestfile.json");
           /* File file = new File("/sdcard/Android/data/com.adobe.dps.viewer.jupiter/files/801ae87c-1086-4b33-907b-99189dc6a880/manifest.json");
            FileInputStream stream = new FileInputStream(file);
            String jsonStr = null;
            try {
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

                jsonStr = Charset.defaultCharset().decode(bb).toString();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally {
                stream.close();
            }

            JSONObject jsonObj = new JSONObject(jsonStr);
            ArrayList<String> arrayList=new ArrayList<>();
            // Getting data JSON Array nodes
            JSONArray data  = jsonObj.getJSONObject("_links").getJSONArray("resources");
            // looping through All nodes
            for (int i = 1; i < data.length(); i++) {
                JSONObject fileLength = data.getJSONObject(i);
                String length = fileLength.getString("length");
                arrayList.add(length);
            }

            long totalLength = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                totalLength = totalLength + Long.parseLong(arrayList.get(i));
            }

            Log.i(TAG, "ReadJsonFile: totalLength is >>>  "+totalLength);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> nameValue=new HashSet<>();
        String[] arr={"hi", "hi","hello","hari"};
        for (String name : arr) {
            nameValue.add(name);
        }

        Iterator iterator=nameValue.iterator();
        while (iterator.hasNext()){
            Log.i(TAG, "ReadJsonFile: name value is >>> "+iterator.next());
        }*/


        ///

        try {
            File file = new File("/sdcard/Android/data/com.adobe.dps.viewer.jupiter/files/c0975daf-ac12-4782-8c3a-8915ec1d32b2/manifest.xml");
            FileInputStream fin = new FileInputStream(file);
//            InputStream is = getAssets().open("file.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fin);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("resource");
            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
//                    Log.e(TAG, "ReadJsonFile: >> " + getValue("name", element2));
//                    tv1.setText(tv1.getText()+"\nName : " + getValue("name", element2)+"\n");
//                    tv1.setText(tv1.getText()+"Salary : " + getValue("salary", element2)+"\n");
//                    tv1.setText(tv1.getText()+"-----------------------");
                }
            }//end of for loop

        } catch (Exception e) {e.printStackTrace();}

        /*try {
            File file = new File("/sdcard/Android/data/com.adobe.dps.viewer.jupiter/files/c0975daf-ac12-4782-8c3a-8915ec1d32b2/manifest.xml");
            FileInputStream fin = new FileInputStream(file);
            // Build XML document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(new InputSource(new FileInputStream(file)));
            Element elt;
            elt = dom.getDocumentElement();
            NodeList items = elt.getElementsByTagName("resources");
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            if (file.exists()){

            }
        }
        catch(Exception e){
        }*/
        ///
    }
}
