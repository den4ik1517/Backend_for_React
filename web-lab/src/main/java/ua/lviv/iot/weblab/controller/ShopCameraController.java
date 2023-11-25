package ua.lviv.iot.weblab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.weblab.model.Camera;
import ua.lviv.iot.weblab.service.ShopCameraService;

import java.util.List;

@RestController
@RequestMapping("/cameras")
public class ShopCameraController {
   final private ShopCameraService shopCameraService;

   @Autowired
   public ShopCameraController(ShopCameraService shopCameraService) {
      this.shopCameraService = shopCameraService;
   }

   @CrossOrigin
   @GetMapping
   public List<Camera> getAll() {
      return shopCameraService.getAll();
   }

   @CrossOrigin
   @GetMapping("/{id}")
   public Camera getCamera(@PathVariable("id") Integer id) {
      return shopCameraService.getCamera(id);
   }

   @CrossOrigin
   @PutMapping("/update/{id}")
   public void updateCamera(@PathVariable("id") Integer id, @RequestBody Camera camera) {
      shopCameraService.updateCamera(id, camera);
   }

   @CrossOrigin
   @PostMapping("/add")
   public void createCamera (@RequestBody Camera camera) {

      shopCameraService.createCamera(camera);
   }

   @CrossOrigin
   @DeleteMapping("/delete/{id}")
   public void deleteCamera (@PathVariable("id") Integer id) {
      shopCameraService.deleteCamera(id);
   }
}
