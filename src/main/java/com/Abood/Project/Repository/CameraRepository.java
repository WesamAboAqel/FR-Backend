package com.Abood.Project.Repository;

import com.Abood.Project.Entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, String> {
    // Find all Cameras by status
    List<Camera> findByStatus(String status);

    // Find Cameras located at a specific location
    List<Camera> findByLocationIgnoreCase(String location);

    // Count the number of Cameras
    long count();

    // Delete a Camera by ID
    void deleteByCameraID(String cameraID);
}
