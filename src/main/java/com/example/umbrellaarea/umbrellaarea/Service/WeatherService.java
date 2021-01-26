package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.DTO.WeatherDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Stack;

@Service
public class WeatherService {
    Date date=new Date(System.currentTimeMillis());
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy년MM월dd일");
    String http="http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst?";
    String key="a40IKe0YkEodpzmVP916YKAZir85%2Fa2PO5QgeY%2BrKEwFTxZL%2FkvEwu3sWJrSB4sr3Ks8uTkIme4cT0Xx2jbi4A%3D%3D";
    String day=simpleDateFormat.format(date);
    String[] nx={"60","60","69","91","51","73","52"};
    String[] ny={"127","120","107","77","67","134","38"};
    String[] local={"서울","경기도","충청도","경상도","전라도","강원도","제주도"};
    String dataType="json";
    String numOfRows="70";
    String pageNo ="1";
    String[] weekDay = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
    Calendar cal = Calendar.getInstance();
    int num = cal.get(Calendar.DAY_OF_WEEK)-1;

    public ArrayList<WeatherDTO> weater(){
        ArrayList<WeatherDTO> arrayList=new ArrayList<WeatherDTO>();
        for (int index = 0; index <ny.length ; index++) {
            Stack<String> LGT = new Stack<String>();
            Stack<String> T1H = new Stack<String>();
            Stack<String> SKY = new Stack<String>();
            Stack<String> PTY = new Stack<String>();
            String strurl = http + "serviceKey=" + key + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&dataType=" + dataType + "&base_date=" + day + "&base_time=0630&nx="+nx[index]+"&ny="+ny[index]+"";
            JSONArray jsonArray = JSONParsing(strurl);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject date = (JSONObject) jsonArray.get(i);
                if (date.get("category").toString().equals("LGT")) {
                    LGT.push(date.get("fcstValue").toString());
                } else if (date.get("category").toString().equals("T1H")) {
                    T1H.push(date.get("fcstValue").toString());
                } else if (date.get("category").toString().equals("SKY")) {
                    SKY.push(date.get("fcstValue").toString());
                } else if (date.get("category").toString().equals("PTY")) {
                    PTY.push(date.get("fcstValue").toString());
                }
            }
            WeatherDTO weatherDTO = new WeatherDTO(
                    LGT.peek(),
                    T1H.peek(),
                    SKY.peek(),
                    PTY.peek()
            );
            weatherDTO.setLocal(local[index]);
            weatherDTO.setDate(simpleDateFormat1.format(date)+" "+weekDay[num]);
            arrayList.add(weatherDTO);
        }

            return arrayList;

    }

    public JSONArray JSONParsing(String strurl){
        JSONArray JsonArray=null;
        StringBuffer stringBuffer =new StringBuffer();
        try{
            URL url = new URL(strurl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String stringline;

            while ((stringline = bufferedReader.readLine()) != null) {
                stringBuffer.append(stringline + "\n");
            }

            JSONParser jsonParser=new JSONParser();
            JSONObject jobj= (JSONObject) jsonParser.parse(String.valueOf(stringBuffer));
            jobj= (JSONObject)((JSONObject)((JSONObject) jobj.get("response")).get("body")).get("items");
            JsonArray= (JSONArray) jobj.get("item");

            httpURLConnection.disconnect();

        }catch (Exception e){
            System.out.println("JSONParsing 오류"+e);
        }
        return JsonArray;
    }

}
