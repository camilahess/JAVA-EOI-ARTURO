package com.eoi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@AllArgsConstructor
@Data //Esto sustituye lo de abajo
// @ToString
// @EqualsAndHashCode
//@Getter @Setter
@NoArgsConstructor
public class Persona {
    
    private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private LocalDate fechaNacimiento;

}
