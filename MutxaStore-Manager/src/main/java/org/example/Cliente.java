package org.example;

    import java.time.LocalDate;

    public class Cliente {

        // Atributos
        private int idCliente;
        private String nombre;
        private String apellidos;
        private String email;
        private LocalDate fechaRegistro;

        // Constructor
        public Cliente(int idCliente, String nombre, String apellidos, String email, LocalDate fechaRegistro) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.email = email;
            this.fechaRegistro = fechaRegistro;
        }

        //Getters y Setters
        public int getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(int idCliente) {
            this.idCliente = idCliente;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDate getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        //ToString

        @Override
        public String toString() {
            return "Cliente{" +
                    "idCliente=" + idCliente +
                    ", nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", email='" + email + '\'' +
                    ", fechaRegistro=" + fechaRegistro +
                    '}';
        }
    }
