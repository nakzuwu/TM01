package Model;

public class ResponseModel {
    private String massage;
    private String status;
    private String comment;
    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public ResponseModel(){
    }
    public static void main(String[] args) {
        ResponseModel respon = new ResponseModel();
        respon.setMassage("Data received");
        respon.setStatus("Halo siswa algo2");
        respon.setComment("anda sudah terkoneksi ke server mimoapps");
    }
}