/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelos;

import static app.modelos.AutorModelo.filtrar;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.mvc.Modelado;
import mojica.alexander.mvc.ModeloTabla;

/**
 *
 * @author MekakuZero
 */
public class CategoriaModelo extends Conexion implements Modelado {

    private int id;
    private String categoria;
    private String descripcion;
    
    public CategoriaModelo() {}
    
    public CategoriaModelo(CategoriaModelo categoria) {
        this.id = categoria.id;
        this.categoria = categoria.categoria;
        this.descripcion = categoria.descripcion;
    }
    
    public CategoriaModelo(ResultSet resultado){
        try{
            this.id = resultado.getInt("id");
            this.categoria = resultado.getString("categoria");
            this.descripcion = resultado.getString("descripcion");
        } catch(Exception error){}
    }
    
    public CategoriaModelo(String categoria) {
        this.categoria = categoria;
    }
    
    public static ModeloTabla getModelo(String categoria){
        String columnas[] = new String[]{"ID", "Categoria", "Descripcion"};
        
        List<Modelado> lista = filtrar(categoria);
        
        ModeloTabla modelo = new ModeloTabla(lista, columnas);
        
        return modelo;
    }
    
    // Leer los datos de la tabla
    public static List<Modelado> filtrar(String categoria){
        List<Modelado> modelos = new ArrayList<>();
        
        CategoriaModelo modelo = new CategoriaModelo();
        
        modelo.conectar();
        
        modelo.crearQuery("SELECT * FROM categoria WHERE categoria like concat('%',?,'%')");
        
        modelo.agregarParametro(1, categoria);
        
        ResultSet resultado = modelo.getResultSet();
        
        try{
            while(resultado.next())
                modelos.add(new CategoriaModelo(resultado));
        } catch(Exception error){
            System.out.println("Obtener filas error: " + error.getMessage());
        }
        
        modelo.desconectar();
        
        return modelos;
    }
    
    @Override
    public boolean guardar() {
        String consulta = "INSERT INTO categoria (categoria, descripcion) VALUES (?,?)";
        
        this.conectar();
        
        this.crearQuery(consulta);
        
        this.agregarParametro(1, categoria);
        this.agregarParametro(2, descripcion);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("DELETE FROM categoria WHERE id = ?");
        
        this.agregarParametro(1, this.id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean actualizar() {
        this.conectar();
        
        this.crearQuery("UPDATE categoria SET categoria = ?, descripcion = ? WHERE id = ?");
        
        this.agregarParametro(1, this.categoria);
        this.agregarParametro(2, this.descripcion);
        this.agregarParametro(3, this.id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public Object[] crearFilaModelo() {
        return new Object[]{ this.id, this.categoria, this.descripcion };
    }

    // Propiedades de la clase de categoria
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion.isEmpty())
            this.descripcion = null;
        else
            this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
