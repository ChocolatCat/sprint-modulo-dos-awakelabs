import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println(" ----------------------------- ");
            System.out.println("| 1. Almacenar Cliente        |");
            System.out.println("| 2. Almacenar Profesional    |");
            System.out.println("| 3. Almacenar Administrativo |");
            System.out.println("| 4. Almacenar Capacitacion   |");
            System.out.println("| 5. Eliminar Usuario         |");
            System.out.println("| 6. Listar Usuarios          |");
            System.out.println("| 7. Listar Usuarios por Tipo |");
            System.out.println("| 8. Listar Capacitaciones    |");
            System.out.println("| 9. Salir                    |");
            System.out.println(" ----------------------------- ");
            opcion = scan.nextInt();
            scan.nextLine();
            switch(opcion){
                case 1:
                    AgregarCliente(contenedor);
                    break;
                case 2:
                    AgregarProfesional(contenedor);
                    break;
                case 3:
                    AgregarAdministrativo(contenedor);
                    break;
                case 4:
                    if(contenedor.listaAsesorias.size() > 0){
                        AgregarCapacitacion(contenedor);
                    }
                    else{
                        System.out.println("No hay usuarios a los cuales asociar la capacitacion.");
                    }
                    break;
                case 5:
                    EliminarUser(contenedor);
                    break;
                case 6:
                    ListarUsuarios(contenedor);
                    break;
                case 7:
                    ListarPorTipo(contenedor);
                    break;
                case 8:
                    ListarCapacitaciones(contenedor);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!");
                    break;
            }
        }while(opcion != 9);
    }

    public static void AgregarCliente(Contenedor contenedor){
        Scanner scan = new Scanner(System.in);
        String nombreUsuario = "", fechaNacimiento = "", nombres = "",
                apellidos = "", telefono = "", afp = "", direccion = "", comuna = "",
                rutHolder = "", sisSaludHolder = "", edadHolder = "";
        boolean valido = false;
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        int rut = 0, sisSalud = 0, edad = -1;
        System.out.println("Ingrese el nombre de usuario del cliente (10 a 50 caracteres):");
        do{
            nombreUsuario = scan.nextLine().trim();
            if(nombreUsuario.length() < 10 || nombreUsuario.length() > 50){
                System.out.println("El nombre de usuario debe ser de 10 a 50 caracteres");
            }
        }while(nombreUsuario.length() < 10 || nombreUsuario.length() > 50);
        System.out.println("Ingrese la fecha de nacimiento del cliente (Formato dd/MM/yyyy o similares):");
        do{
            fechaNacimiento = scan.nextLine().trim();
            if(!fechaNacimiento.matches(regex)){
                System.out.println("Ingrese una fecha valida!");
            }
        }while(!fechaNacimiento.matches(regex));
        System.out.println("Ingrese el rut del cliente sin digito verificador:");
        do{
            rutHolder = scan.nextLine().trim();
            try{
                rut = Integer.parseInt(rutHolder);
            }
            catch(NumberFormatException nfe){
                rut = 0;
            }
            finally {
                if(rut == 0){
                    System.out.println("Ingrese un rut valido!");
                }
                else if(rut > 99999999){
                    System.out.println("El rut maximo es 99.999.999 sin puntos!");
                }
            }
        }while(rut > 99999999 || rut <= 0);
        System.out.println("Ingrese los nombres del cliente (5-30 caracteres):");
        do{
            nombres = scan.nextLine().trim();
            if(nombres.length() < 5){
                System.out.println("Nombres muy cortos");
            }
            else if(nombres.length() > 30){
                System.out.println("Nombres muy largos");
            }
        }while(nombres.length() < 5 || nombres.length() > 30);
        System.out.println("Ingrese los apellidos del cliente:");
        do{
            apellidos = scan.nextLine().trim();
            if(apellidos.length() < 5){
                System.out.println("Apellidos muy cortos");
            }
            else if(apellidos.length() > 30){
                System.out.println("Apellidos muy largos");
            }
        }while(apellidos.length() < 5 || apellidos.length() > 30);
        System.out.println("Ingrese el telefono del cliente:");
        do{
            valido = false;
            telefono = scan.nextLine().trim();
            try{
                Integer.parseInt(telefono);
                valido = true;
            }
            catch(NumberFormatException nfe){
                System.out.println("Ingrese solo numeros para el telefono");
            }
        }while(telefono.length() < 1 || !valido);
        System.out.println("Ingrese la AFP del cliente (4 a 30 caracteres):");
        do{
            afp = scan.nextLine().trim();
            if(afp.length() < 4){
                System.out.println("Nombre de AFP muy corto");
            }
            else if(afp.length() > 30){
                System.out.println("Nombre de AFP muy largo");
            }
        }while(afp.length() < 4 || afp.length() > 30);
        System.out.println("Ingrese el sistema de salud del cliente. Use 1 para FONASA y 2 para ISAPRE:");
        do{
            sisSaludHolder = scan.nextLine();
            try{
                sisSalud = Integer.parseInt(sisSaludHolder);
                if(sisSalud < 0 || sisSalud > 2){
                    System.out.println("Ingrese un valor valido! (1 o 2)");
                }
            }
            catch(NumberFormatException nfe){
                sisSalud = 0;
                System.out.println("Ingrese solo numeros para el sistema de salud!");
            }
        }while(sisSalud <= 0 || sisSalud > 2);
        System.out.println("Ingrese la direccion del cliente:");
        do{
            direccion = scan.nextLine().trim();
            if(direccion.length() > 70){
                System.out.println("Direccion muy larga");
            }
        }while(direccion.length() > 70);
        System.out.println("Ingrese la comuna de residencia del cliente:");
        do{
            comuna = scan.nextLine().trim();
            if(comuna.length() > 50){
                System.out.println("Direccion muy larga");
            }
        }while(comuna.length() > 70);
        System.out.println("Ingrese la edad del cliente (Maximo 149 anios):");
        do{
            edadHolder = scan.nextLine();
            try{
                edad = Integer.parseInt(edadHolder);
                if(edad < 0 || edad >= 150){
                    System.out.println("Ingrese un valor valido! (0 o 149)");
                }
            }
            catch(NumberFormatException nfe){
                System.out.println("Ingrese solo numeros para la edad");
            }
        }while(edad < 0 || edad >= 150);
        Cliente cliente = new Cliente(nombreUsuario, fechaNacimiento, rut, nombres,
                apellidos, telefono, afp, sisSalud, direccion, comuna, edad);
        contenedor.listaAsesorias.add(cliente);

    }
    public static void AgregarProfesional(Contenedor contenedor){
        String nombreUsuario = "", fechaNacimiento = "", rutHolder = "", titulo = "", fechaIngreso = "";
        int rut = 0;
        Scanner scan = new Scanner(System.in);
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        System.out.println("Ingrese el nombre de usuario del profesional:");
        do{
            nombreUsuario = scan.nextLine().trim();
            if(nombreUsuario.length() < 10 || nombreUsuario.length() > 50){
                System.out.println("El nombre de usuario debe ser de 10 a 50 caracteres");
            }
        }while(nombreUsuario.length() < 10 || nombreUsuario.length() > 50);
        System.out.println("Ingrese la fecha de nacimiento del profesional (Formato dd/MM/yyyy o similares):");
        do{
            fechaNacimiento = scan.nextLine().trim();
            if(!fechaNacimiento.matches(regex)){
                System.out.println("Ingrese una fecha valida!");
            }
        }while(!fechaNacimiento.matches(regex));
        System.out.println("Ingrese el rut del profesional:");
        do{
            rutHolder = scan.nextLine().trim();
            try{
                rut = Integer.parseInt(rutHolder);
            }
            catch(NumberFormatException nfe){
                rut = 0;
            }
            finally {
                if(rut == 0){
                    System.out.println("Ingrese un rut valido!");
                }
                else if(rut > 99999999){
                    System.out.println("El rut maximo es 99.999.999 sin puntos!");
                }
            }
        }while(rut > 99999999 || rut <= 0);
        System.out.println("Ingrese el titulo del profesional (10 a 50 caracteres):");
        do{
            titulo = scan.nextLine().trim();
            if(titulo.length() > 50){
                System.out.println("Titulo muy largo");
            }
            else if(titulo.length() < 10){
                System.out.println("Titulo muy corto");
            }
        }while(titulo.length() > 50 || titulo.length() < 10);
        System.out.println("Ingrese la fecha de ingreso del profesional (Formato dd/MM/yyyy o similares):");
        do{
            fechaIngreso = scan.nextLine().trim();
            if(!fechaIngreso.matches(regex)){
                System.out.println("Ingrese una fecha valida!");
            }
        }while(!fechaIngreso.matches(regex));
        Profesional profesional = new Profesional(nombreUsuario, fechaNacimiento, rut, titulo, fechaIngreso);
        contenedor.listaAsesorias.add(profesional);
    }

    public static void AgregarAdministrativo(Contenedor contenedor){
        String nombreUsuario = "", fechaNacimiento = "", rutHolder = "", area = "", exp = "";
        int rut = 0;
        Scanner scan = new Scanner(System.in);
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        System.out.println("Ingrese el nombre de usuario del administrativo:");
        do{
            nombreUsuario = scan.nextLine().trim();
            if(nombreUsuario.length() < 10 || nombreUsuario.length() > 50){
                System.out.println("El nombre de usuario debe ser de 10 a 50 caracteres");
            }
        }while(nombreUsuario.length() < 10 || nombreUsuario.length() > 50);
        System.out.println("Ingrese la fecha de nacimiento del administrativo:");
        do{
            fechaNacimiento = scan.nextLine().trim();
            if(!fechaNacimiento.matches(regex)){
                System.out.println("Ingrese una fecha valida!");
            }
        }while(!fechaNacimiento.matches(regex));
        System.out.println("Ingrese el rut del administrativo:");
        do{
            rutHolder = scan.nextLine().trim();
            try{
                rut = Integer.parseInt(rutHolder);
            }
            catch(NumberFormatException nfe){
                rut = 0;
            }
            finally {
                if(rut == 0){
                    System.out.println("Ingrese un rut valido!");
                }
                else if(rut > 99999999){
                    System.out.println("El rut maximo es 99.999.999 sin puntos!");
                }
            }
        }while(rut > 99999999 || rut <= 0);
        System.out.println("Ingrese el area del administrativo:");
        do{
            area = scan.nextLine().trim();
            if(area.length() < 5){
                System.out.println("Nombre del area muy corto");
            }
            else if(area.length() > 20){
                System.out.println("Nombre del area muy largo");
            }
        }while(area.length() < 5 || area.length() > 20);
        System.out.println("Ingrese la experiencia previa del administrativo:");
        do{
            exp = scan.nextLine().trim();
            if(exp.length() > 100){
                System.out.println("Acorte la experiencia previa");
            }
        }while(exp.length() > 100);
        Administrativo administrativo = new Administrativo(nombreUsuario, fechaNacimiento, rut, area, exp);
        contenedor.listaAsesorias.add(administrativo);
    }

    public static void AgregarCapacitacion(Contenedor contenedor){
        String rutHolder = "", dia = "", hora = "", lugar = "", duracionHolder = "", cantAsistentesHolder = "";
        String[] diasSemana = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        String horaRegex = "^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$";
        int cantAsistentes = 0, rut = 0;
        double duracion = 0;
        boolean clienteValido = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el rut del cliente:");
        do{
            rutHolder = scan.nextLine().trim();
            try{
                rut = Integer.parseInt(rutHolder);

            }
            catch(NumberFormatException nfe){
                rut = 0;
            }
            finally {
                if(rut == 0){
                    System.out.println("Ingrese un rut valido!");
                }
                else if(rut > 99999999){
                    System.out.println("El rut maximo es 99.999.999 sin puntos!");
                }
            }
        }while(rut > 99999999 || rut <= 0);
        Usuario user = contenedor.ExisteUsuario(rut);
        if(user != null){
            clienteValido = true;
        }
        if(!clienteValido){
            System.out.println("No hay usuario en nuestros registros con ese RUT!");
            return;
        }
        System.out.println("Ingrese el dia de la capacitacion. Use el nombre del dia (Ejemplo: Lunes):");
        do{
            dia = scan.nextLine().trim();
            if(!Arrays.asList(diasSemana).contains(dia.toLowerCase())){
                System.out.println("Ingrese un dia valido. (Ejemplo: Lunes)");
            }
        }while(!Arrays.asList(diasSemana).contains(dia.toLowerCase()));
        System.out.println("Ingrese la hora de la capacitacion. Formato 'HH:MM':");
        do{
            hora = scan.nextLine().trim();
            if(!hora.matches(horaRegex)){
                System.out.println("Ingrese una hora valida!");
            }
        }while(!hora.matches(horaRegex));
        System.out.println("Ingrese el lugar de la capacitacion:");
        do{
            lugar = scan.nextLine().trim();
            if(lugar.length() < 10){
                System.out.println("Descripcion/Nombre del lugar muy corto");
            }
            else if(lugar.length() > 50){
                System.out.println("Descripcion/Nombre del lugar muy largo");
            }
        }while(lugar.length() < 10 || lugar.length() > 50);
        System.out.println("Ingrese la duracion de la capacitacion. (En horas. Ejemplo: 1.5):");
        do{
            duracionHolder = scan.nextLine().trim();
            try{
                duracion = Double.parseDouble(rutHolder);
            }
            catch(NumberFormatException nfe){
                duracion = 0;
            }
            finally {
                if(duracion == 0){
                    System.out.println("Ingrese una duracion valida!");
                }
            }
        }while(duracion <= 0);
        System.out.println("Ingrese la cantidad de asistentes de la capacitacion:");
        do{
            cantAsistentesHolder = scan.nextLine().trim();
            try{
                cantAsistentes = Integer.parseInt(cantAsistentesHolder);
            }
            catch(NumberFormatException nfe){
                cantAsistentes = 0;
            }
            finally {
                if(cantAsistentes == 0){
                    System.out.println("Debe tener al menos 1 asistente!");
                }
                else if(cantAsistentes >= 1000){
                    System.out.println("La maxima cantidad de asistentes es 999!");
                }

            }
        }while(cantAsistentes >= 1000 || cantAsistentes < 1);
        int id = contenedor.idCapacitacion;
        contenedor.idCapacitacion++;
        Capacitacion cap = new Capacitacion(id, rut, dia, hora, lugar, duracion, cantAsistentes);
        contenedor.listaCapacitacion.add(cap);
    }

    public static void EliminarUser(Contenedor contenedor){
        String rutHolder = "";
        int rut = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el rut del usuario a borrar:");
        do{
            rutHolder = scan.nextLine().trim();
            try{
                rut = Integer.parseInt(rutHolder);
            }
            catch(NumberFormatException nfe){
                rut = 0;
            }
            finally {
                if(rut == 0){
                    System.out.println("Ingrese un rut valido!");
                }
                else if(rut > 99999999){
                    System.out.println("El rut maximo es 99.999.999 sin puntos!");
                }
            }
        }while(rut > 99999999 || rut <= 0);
        Usuario user = contenedor.ExisteUsuario(rut);
        if(user != null){
            contenedor.EliminarUsuario(rutHolder);
        }
        else{
            System.out.println("No existe usuario con ese RUT en los registros.");
        }
    }

    public static void ListarUsuarios(Contenedor contenedor){
        contenedor.ListarUsuarios();
    }

    public static void ListarPorTipo(Contenedor contenedor){
        String tipoHolder = "";
        int tipo = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el tipo de usuario que desea listar.");
        System.out.println("1. Clientes");
        System.out.println("2. Profesionales");
        System.out.println("3. Administrativos");
        do{
            tipoHolder = scan.nextLine().trim();
            try{
                tipo = Integer.parseInt(tipoHolder);
            }
            catch(NumberFormatException nfe){
                tipo = 0;
            }
            finally {
                if(tipo == 0){
                    System.out.println("Ingrese un numero valido!");
                }
                else if(tipo < 1 || tipo > 3){
                    System.out.println("El tipo solo es de 1 a 3!");
                }
            }
        }while(tipo < 1 || tipo > 3);
        contenedor.ListaTipoUsuario(tipo);
    }

    public static void ListarCapacitaciones(Contenedor contenedor){
        contenedor.ListarCapacitaciones();
    }

}