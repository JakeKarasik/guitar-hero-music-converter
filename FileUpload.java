package guitarheromusicconverter;

public class FileUpload {
    
    public File file;
    public Status status;
    
    public class File {
        
        public String file_id, status, href;
        public int remaining_lifetime_seconds;
        
        public File(String file_id, String status, String href, int remaining_lifetime_seconds) {
            
            this.file_id = file_id;
            this.status = status;
            this.href = href;
            this.remaining_lifetime_seconds = remaining_lifetime_seconds;       
        }     
    }
    
    public FileUpload(File file, Status status) {
        
        this.file.file_id = file.file_id;
        this.file.status = file.status;
        this.file.href = file.href;
        this.file.remaining_lifetime_seconds = file.remaining_lifetime_seconds;
        this.status.code = status.code;
    }  
}
