USE billpayment;
INSERT INTO admin values ('admin','admin123');

INSERT INTO vendor_type(vt_type_name) VALUES ('Electricity');
INSERT INTO vendor_type(vt_type_name) VALUES ('Telephone');
INSERT INTO vendor_type(vt_type_name) VALUES ('DTH');
INSERT INTO vendor_type(vt_type_name) VALUES ('Insurance');
INSERT INTO vendor_type(vt_type_name) VALUES ('Credit Card');
INSERT INTO vendor_type(vt_type_name) VALUES ('Loan Account');
INSERT INTO vendor_type(vt_type_name) VALUES ('Tax');

INSERT INTO payment_type(pt_id,pt_type) VALUES (1,'Credit Card');
INSERT INTO payment_type(pt_id,pt_type) VALUES (2,'Debit Card');
INSERT INTO payment_type(pt_id,pt_type) VALUES (3,'Google Pay');
INSERT INTO payment_type(pt_id,pt_type) VALUES (4,'Paytm');
INSERT INTO payment_type(pt_id,pt_type) VALUES (5,'e-Wallet');
INSERT INTO payment_type(pt_id,pt_type) VALUES (6,'Net Banking');


select * from vendor_type;
select * from admin;
select * from vendor;
select * from customer;
SET SQL_SAFE_UPDATES = 0;
select * from bill;
delete from bill;

insert into card values(1,123456789,123,'2022-12-03');
insert into card values(2,123498745,456,'2022-10-04');
insert into card values(3,987456123,789,'2022-08-05');
insert into card values(4,987321654,321,'2022-06-06');
insert into card values(5,456123789,654,'2022-04-07');

insert into phone values(1,122133144);
insert into phone values(2,155166177);
insert into phone values(3,100199188);
insert into phone values(4,144133122);
insert into phone values(5,188177100);


insert into net_banking values(1,777777777,'oviya123','oviya111');
insert into net_banking values(2,888888888,'supriya123','supriya111');
insert into net_banking values(3,999999999,'navina123','navina111');
insert into net_banking values(4,121212121,'kavitha123','kavitha111');
insert into net_banking values(5,343434343,'ram123','ram111');





