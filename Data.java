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
    
    public Data() {
        try {
            //Load API_KEY from txt file for github privacy 
            API_KEY = new Scanner(new File("API_KEY.txt")).nextLine();
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("API_KEY not set - " + ex.getMessage());
            API_KEY = null;
        }
            
    }
    
    public Notes[] downloadSongData(String file_id) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }
        
        String operation = "/analyze/melody";
        
        HttpClient client = HttpClientBuilder.create().build();

        // Create a request instance.
        HttpPost request = new HttpPost(API_BASE_URL + operation);

        //Create POST parameters
        List <NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("access_id", API_KEY));
        params.add(new BasicNameValuePair("input_file", file_id));
        params.add(new BasicNameValuePair("format", "json"));
        
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
            
            //Parse JSON response
            Gson g = new Gson();
            FileDownload download = g.fromJson(result, FileDownload.class);

            //Check if successful response from server
            if (!responseIsSuccess(download.status.code)) {
                
                System.err.println("Error: Invalid response from server.");
                return null;
            }
            
            return download.melody_result.notes;

        } catch (IOException ex) {
            
            System.err.println("Error: " + ex.getMessage());
        }
        
        return null;
    }
    
    //Returns file_id on success, null on failure
    public String uploadSong(String file) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }
           
        String operation = "/file/upload";
        
        HttpClient client = HttpClientBuilder.create().build();

        // Create a request instance.
        HttpPost request = new HttpPost(API_BASE_URL + operation);

        //Create POST parameters
        List <NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("access_id", API_KEY));
        params.add(new BasicNameValuePair("file", file));
        params.add(new BasicNameValuePair("format", "json"));
        
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
            
            //Parse JSON response
            Gson g = new Gson();
            FileUpload upload = g.fromJson(result, FileUpload.class);
            
            //Check if successful response from server
            if (!responseIsSuccess(upload.status.code)) {
                
                System.err.println("Error: Invalid response from server.");
                return null;
            }
            
            return upload.file.file_id;

        } catch (IOException ex) {
            
            System.err.println("Error: " + ex.getMessage());
        }
        
        return null;
    }
    
    private boolean responseIsSuccess(int code) {
        return code >= 200 && code <= 299;
    }
}
