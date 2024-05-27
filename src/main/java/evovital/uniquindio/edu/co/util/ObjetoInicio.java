package evovital.uniquindio.edu.co.util;

import evovital.uniquindio.edu.co.domain.*;
import evovital.uniquindio.edu.co.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ObjetoInicio implements CommandLineRunner {

    private final EspecialidadRepository especialidadRepository;
    private final EstadoPqrsRepository estadoPqrsRepository;
    private final EstadoDiaLibreRepository estadoDiaLibreRepository;
    private final EstadoConsultaRepository estadoConsultaRepository;
    private final AdministradorRepository administradorRepository;
    private final MedicoRepository medicoRepository;

    public static final List<String> ciudades = List.of(
            "Armenia",
            "Filandia",
            "Calarca",
            "Circasia",
            "Montenegro",
            "Quimbaya",
            "Salento",
            "Buenavista",
            "Cordoba",
            "La Tebaida",
            "Pijao",
            "Genova"
    );


    public static final List<String> tiposSangre = List.of(
            "A+",
            "A-",
            "B+",
            "B-",
            "AB+",
            "AB-",
            "O+",
            "O-"
    );

    public static final List<String> epss = List.of(
            "Sura",
            "Coomeva",
            "Sanitas",
            "Compensar",
            "Salud Total",
            "Nueva EPS",
            "Famisanar",
            "Cafesalud",
            "Aliansalud",
            "Medimas",
            "Saludvida",
            "Saludcoop",
            "Cruz Blanca",
            "Colmedica",
            "Ambuq",
            "Comfenalco",
            "Comparta",
            "Asmet Salud",
            "Cajacopi",
            "Capresoca",
            "Caprecom",
            "Cajacopi",
            "Cajacopi",
            "Cajacopi"
    );

    private final List<Especialidad> especialidades = List.of(
            Especialidad.builder().nombre("Medicina General").build(),
            Especialidad.builder().nombre("Cardiologia").build(),
            Especialidad.builder().nombre("Psicologia").build(),
            Especialidad.builder().nombre("Urologia").build()
    );


    private final List<EstadoPqrs> estadosPqrs = List.of(
            EstadoPqrs.builder().estado("Archivado").build(),
            EstadoPqrs.builder().estado("En proceso").build(),
            EstadoPqrs.builder().estado("Cerrado").build()
    );

    private final List<EstadoConsulta> estadosConsulta = List.of(
            EstadoConsulta.builder().estado("Pendiente").build(),
            EstadoConsulta.builder().estado("Atendida").build(),
            EstadoConsulta.builder().estado("En Proceso").build(),
            EstadoConsulta.builder().estado("Cancelada").build()
    );

    private final List<EstadoDiaLibre> estadoDiaLibre = List.of(
            EstadoDiaLibre.builder().estado("Culminado").build(),
            EstadoDiaLibre.builder().estado("Cancelado").build(),
            EstadoDiaLibre.builder().estado("Tomado").build()
    );

    private final List<Administrador> administradores = List.of(
            Administrador.builder()
                    .nombre("admin_arias")
                    .email("admin@gmail.com")
                    .cedula("124923")
                    .estaActivo(true)
                    .password(new BCryptPasswordEncoder().encode("adminarias123"))
                    .build()
    );

    /**
     * Metodo que se ejecuta al iniciar la aplicacion, guarda los estados que son valores constantes en la base de datos
     *
     * @param args incoming main method arguments
     */
    @Override
    public void run(String... args) {
        if (especialidadRepository.findAll().isEmpty()) {
            especialidadRepository.saveAll(
                    especialidades
            );
        }
        if (estadoPqrsRepository.findAll().isEmpty()) {
            estadoPqrsRepository.saveAll(
                    estadosPqrs
            );
        }
        if (estadoConsultaRepository.findAll().isEmpty()) {
            estadoConsultaRepository.saveAll(
                    estadosConsulta
            );
        }
        if (estadoDiaLibreRepository.findAll().isEmpty()) {
            estadoDiaLibreRepository.saveAll(
                    estadoDiaLibre
            );
        }
        if (administradorRepository.findAll().isEmpty()) {
            administradorRepository.saveAll(
                    administradores
            );
        }
    }
}
