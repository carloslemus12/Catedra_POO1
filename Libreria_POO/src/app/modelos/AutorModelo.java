/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelos;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.mvc.Modelado;
import mojica.alexander.mvc.ModeloTabla;

/**
 *
 * @author MekakuZero
 */
public class AutorModelo extends Conexion implements Modelado{
    
    // Informacion del modelo
    private int id;
    private String nombre;
    private String apellido;
    private String seudonimo;
    private Date fecha_nacimiento;
    
    // Constructores del modelo ////////////////////////////////////////////
    public AutorModelo(){
        // ...
    }
    
    public AutorModelo(AutorModelo autor){
        this.id = autor.id;
        this.nombre = autor.nombre;
        this.apellido = autor.apellido;
        this.seudonimo = autor.seudonimo;
        this.fecha_nacimiento = autor.fecha_nacimiento;
    }

    private AutorModelo(ResultSet info){
        try{
            this.id = info.getInt("id");
            this.nombre = (info.getNString("nombre") == null)? "" : info.getNString("nombre");
            this.apellido = (info.getNString("apellido") == null)? "" : info.getNString("apellido");
            this.seudonimo = info.getNString("seudonimo");
            this.fecha_nacimiento = info.getDate("fecha_nacimiento");
        } catch(Exception error){}
    }
    
    public AutorModelo(String seudonimo, Date fecha_nacimiento) {
        this.seudonimo = seudonimo;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    // //////////////////////////////////////////////////////////////////////////////////////////////////
    
    // Metodo para obtener getModelo el cual es en modelo para pasarlo en la tabla
    public static ModeloTabla getModelo(String seudonimo){
        String columnas[] = new String[]{"ID", "Nombre completo", "Seudonimo", "Fecha de nacimiento" };
        
        List<Modelado> lista = filtrar(seudonimo);
        
        ModeloTabla modelo = new ModeloTabla(lista, columnas);
        
        return modelo;
    }
    
    // Filtramos los datos es estatico pues no hace falta instanciar la clase
    public static List<Modelado> filtrar(String seudonimo){
        
        String consulta = "SELECT * FROM autor "
                + "WHERE seudonimo like concat('%',?,'%')";
        
        AutorModelo modelo = new AutorModelo();
        
        modelo.conectar();
        
        modelo.crearQuery(consulta);
        
        modelo.agregarParametro(1, seudonimo);
        
        ResultSet rs = modelo.getResultSet();
        
        List<Modelado> lista = new ArrayList<>();
        
        try {
            while(rs.next()){
                lista.add(new AutorModelo(rs));
            }
        } catch(Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
        
        modelo.desconectar();
    
        return lista;
    }
    
    // Obtenemos las filas del modelo
    @Override
    public Object[] crearFilaModelo(){
        return new Object[]{ this.id, (this.nombre + " " + this.apellido).trim(), this.seudonimo, this.fecha_nacimiento.toString() };
    }
    
    // Guardamos en la base de datos
    @Override
    public boolean guardar(){
        
        // Consulta de la base
        String consulta 
                = "INSERT INTO autor "
                + "(nombre, apellido, seudonimo, fecha_nacimiento)"
                + " VALUES "
                + "(?,?,?,?)";
        
        // Conectamos
        this.conectar();
        
        // Creamos el query
        this.crearQuery(consulta);
        
        // Añadimos los parametros
        this.agregarParametro(1, this.nombre);
        this.agregarParametro(2, this.apellido);
        this.agregarParametro(3, this.seudonimo);
        this.agregarParametro(4, this.fecha_nacimiento);
        
        // Obtenemos lo resultado
        boolean resultado = this.ejecutarQuery() > 0;
        
        // Desconectamos
        this.desconectar();
        
        // Mostramos el resultado
        return resultado;
    }
    
    // Actualizamos el registro
    @Override
    public boolean actualizar(){
        
        // Consulta de la base
        String consulta 
                = "UPDATE autor SET "
                + "nombre = ?, apellido = ?, seudonimo = ?, fecha_nacimiento = ?"
                + " WHERE `autor`.`id` = ?";
        
        // Conectamos
        this.conectar();
        
        // Creamos el query
        this.crearQuery(consulta);
        
        // Añadimos los parametros
        this.agregarParametro(1, this.nombre);
        this.agregarParametro(2, this.apellido);
        this.agregarParametro(3, this.seudonimo);
        this.agregarParametro(4, this.fecha_nacimiento);
        this.agregarParametro(5, this.id);
        
        // Obtenemos lo resultado
        boolean resultado = this.ejecutarQuery() > 0;
        
        // Desconectamos
        this.desconectar();
        
        // Mostramos el resultado
        return resultado;
    }
    
    // Eliminamos el registro
    @Override
    public boolean eliminar(){
        // Consulta de la base
        String consulta = " DELETE FROM `autor` WHERE `autor`.`id` = ?";
        
        // Conectamos
        this.conectar();
        
        // Creamos el query
        this.crearQuery(consulta);
        
        // Añadimos los parametros
        this.agregarParametro(1, this.id);
        
        // Obtenemos lo resultado
        boolean resultado = this.ejecutarQuery() > 0;
        
        // Desconectamos
        this.desconectar();
        
        // Mostramos el resultado
        return resultado;
    }
    
    // Obtener ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    // Obtener informacion
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
