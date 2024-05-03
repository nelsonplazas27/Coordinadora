package com.api.crud.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;

/**
 * Clase que representa el modelo de datos para un usuario en la API.
 */


@Entity
@Table(name="pedido")
public class UserModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "La dirección es obligatoria")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "La dirección debe ser alfanumérica")
        @Column
        private String direccion;

        @NotBlank(message = "La Fecha de Recogida es obligatoria")
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La Fecha de Recogida debe tener el formato YYYY-MM-DD")
        @Column
        private String fechaRecogida;

        @NotBlank(message = "El nombre es obligatorio")
        @Column
        private String nombreEntrega;

        @NotBlank(message = "El apellido es obligatorio")
        @Column
        private String apellidoEntrega;

        @NotBlank(message = "El celular es obligatorio")
        @Pattern(regexp = "^[0-9]+$", message = "El celular debe contener solo números")
        @Column
        private String celularEntrega;

        @NotBlank(message = "El Correo es obligatorio")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "El Correo no es válido")
        private String emailUsuario;

        @NotBlank(message = "La descripción del tipo de vía es obligatoria")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "La descripción del tipo de vía debe ser alfanumérica")
        private String descripcionTipoVia;

        @NotBlank(message = "El aplicativo es obligatorio")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "El aplicativo debe ser alfanumérico")
        private String aplicativo;

        // Getters y setters para los atributos de la clase

        /**
         * Obtiene el ID del usuario.
         * @return El ID del usuario.
         */

        public Long getId() {
                return id;
        }
        /**
         * Establece el ID del usuario.
         * @param id El ID del usuario.
         */
        public void setId(Long id) {
                this.id = id;
        }

        /**
         * Obtiene la dirección del usuario.
         * @return La dirección del usuario.
         */

        public String getDireccion() {
                return direccion;
        }
        /**
         * Establece la dirección del usuario.
         * @param direccion La nueva dirección del usuario.
         */
        public void setDireccion(String direccion) {
                this.direccion = direccion;
        }
        /**
         * Obtiene la fecha de recogida del usuario.
         * @return La fecha de recogida del usuario.
         */
        public String getFechaRecogida() {
                return fechaRecogida;
        }
        /**
         * Establece la fecha de recogida del usuario.
         * @param fechaRecogida La nueva fecha de recogida del usuario.
         */
        public void setFechaRecogida(String fechaRecogida) {
                this.fechaRecogida = fechaRecogida;
        }
        /**
         * Obtiene el nombre de entrega del usuario.
         * @return El nombre de entrega del usuario.
         */
        public String getNombreEntrega() {
                return nombreEntrega;
        }
        /**
         * Establece el nombre de entrega del usuario.
         * @param nombreEntrega El nuevo nombre de entrega del usuario.
         */
        public void setNombreEntrega(String nombreEntrega) {
                this.nombreEntrega = nombreEntrega;
        }
        /**
         * Obtiene el celular de entrega del usuario.
         * @return El celular de entrega del usuario.
         */
        public String getCelularEntrega() {
                return celularEntrega;
        }
        /**
         * Establece el celular de entrega del usuario.
         * @param celularEntrega El nuevo celular de entrega del usuario.
         */
        public void setCelularEntrega(String celularEntrega) {
                this.celularEntrega = celularEntrega;
        }
        /**
         * Obtiene el apellido de entrega del usuario.
         * @return El apellido de entrega del usuario.
         */
        public String getApellidoEntrega() {
                return apellidoEntrega;
        }
        /**
         * Establece el apellido de entrega del usuario.
         * @param apellidoEntrega El nuevo apellido de entrega del usuario.
         */
        public void setApellidoEntrega(String apellidoEntrega) {
                this.apellidoEntrega = apellidoEntrega;
        }
        /**
         * Obtiene el correo del usuario.
         * @return El correo del usuario.
         */
        public String getEmailUsuario() {
                return emailUsuario;
        }
        /**
         * Establece el correo del usuario.
         * @param emailUsuario El nuevo correo del usuario.
         */
        public void setEmailUsuario(String emailUsuario) {
                this.emailUsuario = emailUsuario;
        }

        /**
         * Obtiene la descripción del tipo de vía del usuario.
         * @return La descripción del tipo de vía del usuario.
         */

        public String getDescripcionTipoVia() {
                return descripcionTipoVia;
        }

        /**
         * Establece la descripción del tipo de vía del usuario.
         * @param descripcionTipoVia La nueva descripción del tipo de vía del usuario.
         */

        public void setDescripcionTipoVia(String descripcionTipoVia) {
                this.descripcionTipoVia = descripcionTipoVia;
        }
        /**
         * Obtiene el aplicativo del usuario.
         * @return El aplicativo del usuario.
         */
        public String getAplicativo() {
                return aplicativo;
        }
        /**
         * Establece el aplicativo del usuario.
         * @param aplicativo El nuevo aplicativo del usuario.
         */
        public void setAplicativo(String aplicativo) {
                this.aplicativo = aplicativo;
        }
}


