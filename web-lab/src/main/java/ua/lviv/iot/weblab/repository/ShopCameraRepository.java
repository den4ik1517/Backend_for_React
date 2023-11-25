package ua.lviv.iot.weblab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.weblab.model.Camera;

@Repository
public interface ShopCameraRepository extends JpaRepository<Camera, Integer> {

}
