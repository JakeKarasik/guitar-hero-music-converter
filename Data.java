package guitarheromusicconverter;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.message.BasicNameValuePair;

public class Data {
    
    private String API_KEY;
    private String API_BASE_URL = "http://api.sonicapi.com";
    private Gson g = new Gson();
    
    public Data() {
        try {
            //Load API_KEY from txt file for github privacy 
            API_KEY = new Scanner(new File("API_KEY.txt")).nextLine();
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("API_KEY not set - " + ex.getMessage());
            API_KEY = null;
        }
            
    }
    
    public String getData(List<NameValuePair> params, String op) {
    	
        //Set API KEY for POST request
        params.add(new BasicNameValuePair("access_id", API_KEY));
        
        //Set format to JSON for POST request
        params.add(new BasicNameValuePair("format", "json"));
        
        //Create client
    	HttpClient client = HttpClientBuilder.create().build();

        // Create a request instance.
        HttpPost request = new HttpPost(API_BASE_URL + op);
    	
        //Attempt to send POST request
        try {
            
            //Add params to request
            request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            
            // Execute the request.
            HttpResponse response = client.execute(request);

            //Get response from server into string
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String result = "", line; 
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            
            //Free connection
            request.releaseConnection();
            
            return result;
        } catch (IOException ex) {
	            
	        System.err.println("Error: " + ex.getMessage());
        }
        
        return null;
    }
    
    public MelodyResult downloadSongMelody(String file_id) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }
        
        //Create POST parameters
        List <NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("input_file", file_id));
        
        //Get data
        String result = getData(params, "/analyze/melody");
        
        if (result == null) {
        	return null;
        }
        
        //Parse JSON response
        FileDownload download = g.fromJson(result, FileDownload.class);
        
        //Check if successful response from server
        if (!responseIsSuccess(download.status.code)) {
                
            System.err.println("Error: Invalid response from server.");
            return null;
        }
            
        return download.melody_result;
    }
    
    //Returns file_id on success, null on failure
    public String uploadSong(String file) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }

        //Create POST parameters
        List <NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("file", file));
        
      //Get data
       String result = getData(params, "/file/upload");
        
       if (result == null) {
    	   return null;
       }
        //Parse JSON response
        FileUpload upload = g.fromJson(result, FileUpload.class);
        
        //Check if successful response from server
        if (!responseIsSuccess(upload.status.code)) {
            
            System.err.println("Error: Invalid response from server.");
            return null;
        }
        
        return upload.file.file_id;
    }
    
    private boolean responseIsSuccess(int code) {
        return code >= 200 && code <= 299;
    }
}
