package thuc.ute.ex3springboot4securitymapstructshop.service;

public interface EmailService {
    void sendOtp(String email, String otp, String subject);
}