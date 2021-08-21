import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static File readFile() throws URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource("Input.json");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            return new File(resource.toURI());
        }
    }


    public static void main(String[] args) {
        List<Shape> shapes=new ArrayList<>();
        List<Double> results=new ArrayList<>();
        try {
            File file= readFile();
            FileReader reader = new FileReader(file);
            JSONParser jsonParser= new JSONParser();
            Object obj = jsonParser.parse(reader);
//            JSONObject = jsonParser.parse(obj).;
            JSONObject jsonObjects = (JSONObject) obj;
            System.out.println(jsonObjects);
            Boolean defaultValue=true;
            int i=1;
            while(defaultValue){
                JSONObject defaultJsonObject=new JSONObject();
                defaultJsonObject.put("value","false");
                JSONObject jsonObject=(JSONObject)jsonObjects.getOrDefault(String.valueOf(i), defaultJsonObject);
                if(jsonObject.getOrDefault("value",defaultJsonObject).toString() == "false"){
                    defaultValue = false;
                    break;
                }
                else {
                    i++;
                    System.out.println(jsonObject);
                    switch (jsonObject.get("type").toString().toLowerCase(Locale.ROOT)){
                        case "circle":{
                            Circle c=new Circle();
                            c.setRadius(Double.valueOf(jsonObject.get("radius").toString()));
                            shapes.add(c);
                            break;
                        }
                        case "rectangle":{
                            Rectangle r=new Rectangle();
                            r.setBreath(Double.valueOf(jsonObject.get("b").toString()));
                            r.setLength(Double.valueOf(jsonObject.get("l").toString()));
                            shapes.add(r);
                            break;
                        }
                        case "square":{
                            Square s=new Square();
                            s.setSide(Double.valueOf(jsonObject.get("side").toString()));
                            shapes.add(s);
                            break;
                        }
                    }
                }
            }

            //Iterate over employee array
//            objectList.forEach( it -> {
//                switch (it.)
//            } );
            shapes.forEach(it->{
                System.out.println(it.toString());
                results.add(it.area());
            });
            results.forEach(it->{
                System.out.println(" Area: "+it);
            });
            try (FileWriter outputFile = new FileWriter("Output.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                outputFile.write(String.valueOf(results));
                outputFile.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");
    }
}
