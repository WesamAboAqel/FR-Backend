package com.Abood.Project.Service;

import com.Abood.Project.Entity.Camera;
import com.Abood.Project.Repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository repository;

    public List<Camera> getAllCameras() {
        return repository.findAll();
    }

    public Camera saveCamera(Camera camera) {
        return repository.save(camera);
    }

    public void deleteCamera(String id) {
        repository.deleteByCameraID(id);
    }

    public List<Camera> findCamerasByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Camera> findCamerasByLocation(String location) {
        return repository.findByLocationIgnoreCase(location);
    }
}
