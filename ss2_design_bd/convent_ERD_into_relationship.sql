drop database ss2_bt1;
create database if not exists ss2_bt1;
use ss2_bt1;
create table phieu_xuat (
so_px int primary key,
ngay_xuat date
);
create table vat_tu(
ma_vtu int auto_increment primary key,
ten_vtu varchar(50)
);
create table vat_tu_phieu_xuat(
 so_px int,
 ma_vtu int,
 dg_xuat float,
 sl_xuat int,
 primary key(so_px,ma_vtu),
 foreign key(so_px) references phieu_xuat(so_px),
 foreign key(ma_vtu) references vat_tu(ma_vtu)
);
create table phieu_nhap(
so_pn int primary key auto_increment,
ngay_nhap date
);
create table vat_tu_phieu_nhap(
 so_pn int,
 ma_vtu int,
 dg_nhap float,
 sl_nhap int,
 primary key(so_pn,ma_vtu),
 foreign key(so_pn) references phieu_nhap(so_pn),
 foreign key(ma_vtu) references vat_tu(ma_vtu)
);
create table sdt(
id int primary key auto_increment,
ma_ncc int,
sdt varchar(50),
foreign key(ma_ncc) references nha_cc(ma_ncc)
);
create table nha_cc(
ma_ncc int primary key auto_increment,
ten_ncc varchar(50),
dia_chi varchar(50),
sdt_id int
);
create table don_dh(
so_dh int primary key auto_increment,
ngay_dh date,
ma_ncc int,
foreign key(ma_ncc) references nha_cc(ma_ncc)
);
create table vat_tu_don_dh(
 so_dh int,
 ma_vtu int,
 dg_nhap float,
 sl_nhap int,
 primary key(so_dh,ma_vtu),
 foreign key(so_dh) references don_dh(so_dh),
 foreign key(ma_vtu) references vat_tu(ma_vtu)
);

