package com.civil.userlocation.entity;

public class User {

        int id;
        private String first_name;
        private String last_name ;
        private String email ;
        private String ip_address;
        private double latitude ;
        private double longitude ;

        public User(int id, String first_name, String last_name, String email, String ip_address, double latitude, double longitude) {
            this.id = id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.ip_address = ip_address;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public User() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIp_address() {
            return ip_address;
        }

        public void setIp_address(String ip_address) {
            this.ip_address = ip_address;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", email='" + email + '\'' +
                    ", ip_address='" + ip_address + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }



