package guitarheromusicconverter;

public class FileUpload {
    
    public FileResult file_result;
    public Status status;
    
    public class FileResult {
        
        public String file_id, status, href;
        public int remaining_lifetime_seconds;
        
        public FileResult(String file_id, String status, String href, int remaining_lifetime_seconds) {
            
            this.file_id = file_id;
            this.status = status;
            this.href = href;
            this.remaining_lifetime_seconds = remaining_lifetime_seconds;       
        }     
    }
    
    public FileUpload(FileResult file_result, Status status) {
        
        this.status.code = status.code;
        this.file_result = new FileResult(file_result.file_id, file_result.status, file_result.href, file_result.remaining_lifetime_seconds);
    }  
}
