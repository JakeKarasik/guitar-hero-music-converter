package guitarheromusicconverter;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class Data {
    
    private String API_KEY;
    private String API_BASE_URL = "http://api.sonicapi.com";
    private Gson g = new Gson();
    
    public Data() {
        try {
            //Load API_KEY from txt file for github privacy 
            API_KEY = new Scanner(new File("API_KEY.txt")).nextLine();
            
        } catch (FileNotFoundException ex) {
            
            System.err.println("Error: API_KEY failed to load - " + ex.getMessage());
            API_KEY = null;
        }
            
    }
    
    public String getData(MultipartEntityBuilder params, String op) {
    	 
        //Set API KEY for POST request
        params.addTextBody("access_id", API_KEY);

        //Set format to JSON for POST request     
        params.addTextBody("format", "json");

        //Add params to request
        HttpEntity params_entity = params.build();
        
        //Create client
    	HttpClient client = HttpClientBuilder.create().build();

        // Create a request instance.
        HttpPost request = new HttpPost(API_BASE_URL + op);
    	
        //Attempt to send POST request
        try {
            
            //Add POST params to request
            request.setEntity(params_entity);
            
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
    
    public Melody downloadMelody(String file_id) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }
        
        //Create multipart builder for file upload
        MultipartEntityBuilder params = MultipartEntityBuilder.create();
        
        //Add file_id for POST request
        params.addTextBody("input_file", file_id);
        
        //Get data
        String result = getData(params, "/analyze/melody");
        
        if (result == null) {
            return null;
        }
        
        //Parse JSON response
        Melody mr = g.fromJson(result, Melody.class);
        
        //Check if successful response from server
        if (!responseIsSuccess(mr.status.code)) {
                
            System.err.println("Error: Invalid response from server.");
            return null;
        }
         
        return mr;
    }
    
    public Chord downloadChords(String file_id) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }
        
        //Create multipart builder for file upload
        MultipartEntityBuilder params = MultipartEntityBuilder.create();
        
        //Add file_id for POST request
        params.addTextBody("input_file", file_id);
        
        //Get data
        String result = getData(params, "/analyze/chords");
        
        if (result == null) {
        	return null;
        }
        
        //Parse JSON response
        Chord cr = g.fromJson(result, Chord.class);
        
        //Check if successful response from server
        if (!responseIsSuccess(cr.status.code)) {
                
            System.err.println("Error: Invalid response from server.");
            return null;
        }
            
        return cr;
    }
   
    //Returns file_id on success, null on failure
    public String uploadSong(String file) {
        
        if (API_KEY == null) {
            System.err.println("Error: API_KEY not set.");
            return null;
        }

        //Create multipart builder for file upload
        MultipartEntityBuilder params = MultipartEntityBuilder.create();
        
        //Add file for POST request
        params.addBinaryBody("file", new File(file));
        
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
