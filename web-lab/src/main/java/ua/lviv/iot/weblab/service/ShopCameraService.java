package ua.lviv.iot.weblab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.weblab.model.Camera;
import ua.lviv.iot.weblab.repository.ShopCameraRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ShopCameraService {

   final private ShopCameraRepository shopCameraRepository;

   @Autowired
   public ShopCameraService(ShopCameraRepository shopCameraRepository) {
      this.shopCameraRepository = shopCameraRepository;
   }

   public void createCamera(Camera camera) {
      shopCameraRepository.save(camera);
   }

   public Camera getCamera(Integer id) {
      Optional<Camera> optionalCamera = Optional.ofNullable(shopCameraRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
      Camera camera = optionalCamera.get();
      return camera;
   }

   public List<Camera> getAll() {
      return (List<Camera>) shopCameraRepository.findAll();
   }

   @Transactional
   public void updateCamera(Integer id, Camera camera) {
      Camera newCamera = shopCameraRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
      newCamera.setNameOfManufacturer(camera.getNameOfManufacturer());
      newCamera.setMemoryCapacity(camera.getMemoryCapacity());
      newCamera.setZoomFactor(camera.getZoomFactor());
   }

   public void deleteCamera(Integer id) {
      shopCameraRepository.deleteById(id);
   }
}
