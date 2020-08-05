package PEJ;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;

    @RequestMapping(method=RequestMethod.POST, path="/cancellations")
    public void cancelDelivery(@RequestBody Delivery delivery){

     System.out.println("###cancelDelivery_0" + delivery.getDeliveryStatus());

     try {
        Thread.currentThread().sleep((long) (400 + Math.random() * 220));
     } catch (InterruptedException e) {
        e.printStackTrace();
     }

     Delivery deliveryCancelled = deliveryRepository.findByOrderId(delivery.getOrderId());
     deliveryCancelled.setDeliveryStatus("CANCELLED");
     deliveryRepository.save(deliveryCancelled);

     System.out.println("###cancelDelivery_1" + delivery.getDeliveryStatus());

//     DeliveryCancelled DeliveryCancelled2 = new DeliveryCancelled();
//     BeanUtils.copyProperties(this, DeliveryCancelled2);
//     DeliveryCancelled2.publishAfterCommit();

     //System.out.println("###cancelDelivery_2" + DeliveryCancelled2);

    }
 }
