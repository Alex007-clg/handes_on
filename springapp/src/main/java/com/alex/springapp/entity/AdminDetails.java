    package com.alex.springapp.entity;

    import jakarta.persistence.CascadeType;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.OneToOne;
    import jakarta.persistence.Table;

    @Entity
    @Table(name = "Admin_Details")
    public class AdminDetails {
        @Column(name = "id")
        @Id
        public long id;

        @Column(name = "email")
        public String email;

        @Column(name = "address")
        public String address;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "Admin_Joint",referencedColumnName = "email")
        public Admin admin;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Admin getAdmin() {
            return admin;
        }

        public void setAdmin(Admin admin) {
            this.admin = admin;
        }

        public AdminDetails(long id, String email, String address, Admin admin) {
            this.id = id;
            this.email = email;
            this.address = address;
            this.admin = admin;
        }

        public AdminDetails() {
        }

        

    }
