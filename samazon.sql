create database samazon;

use samazon;


DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `PRODUCTID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCTNAME` VARCHAR(141) DEFAULT NULL,
  `PRODUCTDESC` varchar(141) DEFAULT NULL,
  `PRODUCTCOUNT` int(11) DEFAULT 0,
  `STOCK` int(11) DEFAULT 100,
  `PRICE` FLOAT(11,2) DEFAULT NULL,
   PRIMARY KEY (`PRODUCTID`)
 ) AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
 
/*!40101 SET character_set_client = @saved_cs_client */;


insert into `products` values(1,'H20 Perfected 24 Pack','',24,100,14.99); 
insert into `products` values(2,'Crunch On V-Pack','',20,100,11.99); 
insert into `products` values(3,'Health Fanatics Vitamins','',40,100,24.99); 
insert into `products` values(4,'Amazon Echo - Black','',1,100,179.99); 
insert into `products` values(5,'Asus VS1273 144hz HD Monitor ','',1,100,189.99); 
insert into `products` values(6,'Divono Sofa','',1,100,385); 
insert into `products` values(7,'Beats Headphones by Dr. Dre','',1,100,299.99); 
insert into `products` values(8,'Dove Soap','',2,100,10.99);
insert into `products` values(9,'Atlanta\s Toma Toes tomatoes','',6,100,14.99); 
 insert into `products` values(10,'Checkmate 3-Ring Binder','',4,100,25); 
 insert into `products` values(11,'Golden Graphite Pack-o-Pencils','',72,100,19.99);
 insert into `products` values(12,'Tom-Tom GPS System','',1,100,129.99);
 insert into `products` values(13,'Blendrite Blender','',1,100,47.99);
 insert into `products` values(14,'Roadmaster 26inch Bicycle','',1,100,120);
 insert into `products` values(15,'Lord of the Rings Complete Collection','',1,100,27); 
 
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

select * from samuser;

DROP TABLE IF EXISTS `samitems`; 

CREATE TABLE `samitems` (
  `ITEMID` int(11) NOT NULL auto_increment,
  `PRODUCTID` int(11) NOT NULL,
  `PURCHASEDATE` date DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT 0,
  `PRICE` float(11,2) DEFAULT 0.00,
  `SAMID` int(11) NOT NULL,
  `LIST` varchar(10) DEFAULT 'cart',
  PRIMARY KEY (`ITEMID`),
  FOREIGN KEY fk_samid(samid) references samuser(samid),
  FOREIGN KEY fk_productid(productid) references products(productid)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- NULL if not purchased yet 
-- List types: 'CART' for shopping cart, 'WISH' for wish list and 'PURC' for purchase history
insert into samitems values (1,9,NULL,3,4.99,1,'CART');

select * from samitems;