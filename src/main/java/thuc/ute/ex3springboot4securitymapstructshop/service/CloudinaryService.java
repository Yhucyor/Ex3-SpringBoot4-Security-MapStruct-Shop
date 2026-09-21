package thuc.ute.ex3springboot4securitymapstructshop.service;

import org.springframework.web.multipart.MultipartFile;
public interface CloudinaryService {
    CloudinaryUploadResult upload(MultipartFile file);
    void delete(String publicId);
}