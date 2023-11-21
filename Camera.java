package ua.lviv.iot.weblab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "camera")
public class Camera {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @Column
   private String nameOfManufacturer;


   @Column
   private float memoryCapacity;

   @Column
   private float zoomFactor;

   @Column
   private float price;
}
