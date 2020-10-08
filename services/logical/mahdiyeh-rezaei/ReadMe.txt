Online Car Delivery Project

http://193.151.128.91:34473/car/list 
----> show list of cars
+++++++++++++++++++++++++++++++
http://193.151.128.91:50200/car/brand/{brand}/name/{name}/color/{color}
 --------> show price
example:
http://193.151.128.91:50200/car/brand/volvo/name/xc40/color/white
+++++++++++++++++++++++++++++++
/car-delivery -------> go to car delivery service
example:
http://193.151.128.91:46723/car-delivery/brand/bmw/name/i8/color/white/currency/inr/city/punjab
+++++++++++++++++++++++++++++++
eureka:
http://193.151.128.91:8761/
+++++++++++++++++++++++++++++++
zuul:
http://193.151.128.91:8080/car-delivery-service/car-delivery/brand/bmw/name/i8/color/white/currency/rial/city/tehran