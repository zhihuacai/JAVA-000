-- product user 

create table Usr
(
  userId int,
  userName varchar(50),
  nickName varchar(50),
  sex char(1),
  email varchar(100),
  phoneNumber int,
  userLevelId int,
  createTime datetime
);

create table Product
(
	productId int,
    productName varchar(255),
    unitPrice float,
    quantity int
);

create table Address
(
	addressId int,
    userId int,
    country varchar(100),
    province varchar(100),
    city varchar(100),
    addr1 varchar(255),
    addr2 varchar(255),
    zipcode int,
    unitPrice float,
    quantity int
);

create table Shop
(
	shopId int,
    shopName int,
    createTime datetime
);

create table DeliverAgent
(
	deliverAgentId int,
    agentName varchar(255),
    createTime datetime
);

create table PayTransaction
(
	payTransactionId int not null auto_increment primary key,
    payMethond varchar(100),
    fromAccount varchar(50),
    toAccount varchar(50),
    amount float,
    transactionTime datetime,
    transactionStatus varchar(20)
);

create table Orders
(
  orderId int not null auto_increment primary key,
  orderUserId int,
  totalPrice float,
  discountAmount float,
  actualPayAmount float,
  shopId int,
  productId int,
  reciever varchar(255),
  deliverAgentId int,
  deliverType varchar(50),
  addressId int,
  payTransactionId int,
  notes varchar(255),
  orderTime datetime not null, 
  payTime datetime,
  deliverTime datetime
)