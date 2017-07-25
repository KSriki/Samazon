create database samazon;

use samazon;


DROP TABLE`products`;

CREATE TABLE `products` (
  `PRODUCTID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCTNAME` VARCHAR(141) DEFAULT NULL,
  `PRODUCTDESC` varchar(141) DEFAULT NULL,
  `PRODUCTCOUNT` int(11) DEFAULT 0,
  `STOCK` int(11) DEFAULT 100,
  `PRICE` FLOAT(11,2) DEFAULT NULL,
  `IMAGE` VARCHAR(500) DEFAULT NULL,
   PRIMARY KEY (`PRODUCTID`)
 ) AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
 
/*!40101 SET character_set_client = @saved_cs_client */;


insert into `products` values(1,'H20 Perfected 24 Pack','',24,100,14.99,'http://assets.bonappetit.com/photos/57c59da34395c0582bb632b0/master/w_625,c_limit/Waiakea-Main-Pic.jpg'); 
insert into `products` values(2,'Crunch On V-Pack','',20,100,11.99,'http://richmedia.channeladvisor.com/ImageDelivery/imageService?profileId=52000717&imageID=5273&recipeId=243'); 
insert into `products` values(3,'Health Fanatics Vitamins','',40,100,24.99,'https://pics.drugstore.com/prodimg/345567/450.jpg'); 
insert into `products` values(4,'Amazon Echo - Black','',1,100,179.99,'http://theappslab.com/wp-content/uploads/2014/12/AmazonEcho.jpg'); 
insert into `products` values(5,'Asus VS1273 144hz HD Monitor ','',1,100,189.99,'https://www.blogcdn.com/www.engadget.com/media/2013/08/asus-pq321.jpg'); 
insert into `products` values(6,'Divono Sofa','',1,100,385,'https://images2.roomstogo.com/is/image/roomstogo/lr_sof_10141620_bonitasprings_gray~Bonita-Springs-Gray-Sofa.jpeg?$PDP_Primary_936x650$'); 
insert into `products` values(7,'Beats Headphones by Dr. Dre','',1,100,299.99,'https://www.bhphotovideo.com/images/images2500x2500/beats_by_dr_dre_mklf2am_a_solo_2_wireless_on_ear_1152121.jpg'); 
insert into `products` values(8,'Dove Soap','',2,100,10.99,'https://images-na.ssl-images-amazon.com/images/I/51mFZkbLRhL.jpg');
insert into `products` values(9,'Atlanta\s Toma Toes tomatoes','',6,100,14.99,'https://s-media-cache-ak0.pinimg.com/736x/c2/0d/93/c20d93b4006202e18cf55ea371530f84--tomatoes-package-design.jpg'); 
 insert into `products` values(10,'Checkmate 3-Ring Binder','',4,100,25,'https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSLqj4sYATSfs7IjaunFmNHW0BDGmFC5wfqf9G2UFu-sWNt27Au&usqp=CAY'); 
 insert into `products` values(11,'Golden Graphite Pack-o-Pencils','',72,100,19.99,'https://s-media-cache-ak0.pinimg.com/236x/12/03/3c/12033c9e889bf1f483f11f940b2abafc--mechanical-pencils--mm.jpg');
 insert into `products` values(12,'Tom-Tom GPS System','',1,100,129.99,'https://www.laptopmag.com/images/wp/purch-api/incontent/2012/01/TomTom-Start.jpg');
 insert into `products` values(13,'Blendrite Blender','',1,100,47.99,'https://www.cuisinart.com/share/images/products/full/2815/cbb550ss_sd_silo_rgb.jpg');
 insert into `products` values(14,'Roadmaster 26inch Bicycle','',1,100,120,'https://images-na.ssl-images-amazon.com/images/I/816x2fYnMeL._SY355_.jpg');
 insert into `products` values(15,'Lord of the Rings Complete Collection','',1,100,27,'https://images-na.ssl-images-amazon.com/images/I/51GJzbM5vTL._SX373_BO1,204,203,200_.jpg'); 
 
 select * from products;
 
 DROP TABLE IF EXISTS `samuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `samuser` (
  `SAMID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `USERPASSWORD` varchar(50) NOT NULL,
  `ADDRESS` varchar(141) DEFAULT NULL,
  `USEREMAIL` varchar(100) NOT NULL,
  `JOINDATE` date DEFAULT NULL,
  `USERROLE` varchar(100) DEFAULT 'user',
  PRIMARY KEY (`SAMID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
 
-- Normal and prime 
insert into samuser values (1,'Toma','pass','123 Summit Avenue','toma@toes.com', '2017-07-19','normal');
insert into samuser values (2,'Jay','password','21 NC Boulevard','jay@yahoo.com', '2017-07-21','normal');

select * from samuser;

DROP TABLE IF EXISTS `samitems`; 

CREATE TABLE `samitems` (
  `ITEMID` int(11) NOT NULL auto_increment,
  `PRODUCTID` int(11) NOT NULL,
  `PURCHASEDATE` date DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT 0,
  `PRICE` float(11,2) DEFAULT 0.00,
  `SAMID` int(11) NOT NULL,
  `LIST` varchar(10) NOT NULL DEFAULT 'CART',
  PRIMARY KEY (`ITEMID`),
  FOREIGN KEY fk_samid(samid) references samuser(samid),
  FOREIGN KEY fk_productid(productid) references products(productid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- NULL if not purchased yet 
-- List types: 'CART' for shopping cart, 'WISH' for wish list and 'PURC' for purchase history
insert into samitems values (1,9,NULL,3,4.99,1,'CART');
insert into samitems values (4,12,NULL,1,129.99,1,'CART');
insert into samitems values (3,7,'2017-05-21',1,299.99,1,'PURC');
insert into samitems values (2,4,NULL,2,179.99,2,'CART');
select * from samitems;

select * from Samitems p inner join Samuser b on p.samid = b.samid inner join products d on d.productid = p.productid where p.samid = 1 and p.list='PURC' and d.productname like 'Beats Headphones by Dr. Dre';


delete from samitems where itemid > 4;