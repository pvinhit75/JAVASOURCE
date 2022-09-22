package com.company.oop;

public interface InterfaceXe {

    public double GiaTien();
    public class XeOTo implements InterfaceXe{
        private String ma;
        private String hangXe;
        private double giaXeCanBan;

        public XeOTo() {
        }

        public XeOTo(String ma, String hangXe, double giaXeCanBan) {
            this.ma = ma;
            this.hangXe = hangXe;
            this.giaXeCanBan = giaXeCanBan;
        }

        public String getMa() {
            return ma;
        }

        public void setMa(String ma) {
            this.ma = ma;
        }

        public String getHangXe() {
            return hangXe;
        }

        public void setHangXe(String hangXe) {
            this.hangXe = hangXe;
        }

        public double getGiaXeCanBan() {
            return giaXeCanBan;
        }

        public void setGiaXeCanBan(double giaXeCanBan) {
            this.giaXeCanBan = giaXeCanBan;
        }

        @Override
        public double GiaTien() {
            return 0;
        }

        @Override
        public String toString() {
            return "XeOTo{" +
                    "ma='" + ma + '\'' +
                    ", hangXe='" + hangXe + '\'' +
                    ", giaXeCanBan=" + giaXeCanBan +
                    '}';
        }
    }
}
