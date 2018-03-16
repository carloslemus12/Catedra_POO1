/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelos;

import static app.modelos.CategoriaModelo.filtrar;
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
public class TemaModelo extends Conexion implements Modelado {

    private int id;
    private String tema;
    private String descripcion;
    
    public TemaModelo(){}
    
    public TemaModelo(TemaModelo tema){
        this.id = tema.id;
        this.tema = tema.tema;
        this.descripcion = tema.descripcion;
    }
    
    public TemaModelo(ResultSet resultado){
        try{
            this.id = resultado.getInt("id");
            this.tema = resultado.getString("tema");
            this.descripcion = resultado.getString("descripcion");
        } catch(Exception error) {}
    }

    public TemaModelo(String tema) {
        this.tema = tema;
    }
    
    public static ModeloTabla getModelo(String tema){
        String columnas[] = new String[]{"ID", "Tema", "Descripcion"};
        
        List<Modelado> lista = filtrar(tema);
        
        ModeloTabla modelo = new ModeloTabla(lista, columnas);
        
        return modelo;
    }
    
    public static List<Modelado> filtrar(String tema){
        List<Modelado> temas = new ArrayList<>();
        
        TemaModelo tem = new TemaModelo();
        
        tem.conectar();
        
        tem.crearQuery("SELECT * FROM tema WHERE tema like concat('%',?,'%')");
        
        tem.agregarParametro(1, tema);
        
        ResultSet info = tem.getResultSet();
        
        try {
            while(info.next()) temas.add(new TemaModelo(info));
        } catch(Exception error) {  }
        
        tem.desconectar();
        
        return temas;
    }
    
    @Override
    public boolean guardar() {
        this.conectar();
        
        this.crearQuery("INSERT INTO tema (tema, descripcion) VALUES (?, ?)");
        
        this.agregarParametro(1, this.tema);
        this.agregarParametro(2, this.descripcion);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("DELETE FROM tema WHERE id = ?");
        
        this.agregarParametro(1, this.id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean actualizar() {
        this.conectar();
        
        this.crearQuery("UPDATE tema SET tema = ?, descripcion = ? WHERE id = ?");
        
        this.agregarParametro(1, this.tema);
        this.agregarParametro(2, this.descripcion);
        this.agregarParametro(3, this.id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public Object[] crearFilaModelo() {
        return new Object[]{ this.id, this.tema, this.descripcion };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (!descripcion.isEmpty()) 
            this.descripcion = descripcion;
        else
            this.descripcion = null;
    }
    
}
