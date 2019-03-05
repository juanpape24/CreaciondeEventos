package com.example.juanjose.creaciondeeventos.Presentador;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.media.ImageReader;
import android.view.View;
import android.widget.Toast;

import com.example.juanjose.creaciondeeventos.Modelo.Calificacion;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class CalificacionPresenter {
    View vista;
    Calificacion calificacion;

    public CalificacionPresenter(View vista) {
        this.vista = vista;
        calificacion= new Calificacion();
    }

    public void CrearCalificacion(float porcentaje, String comentario, String hora, String fecha, String horaI, String horaF, String fechaE, byte[] multimedia, int idUser, int idEvento){
        String sql;
        calificacion.setHora(hora);
        calificacion.setFecha(fecha);
        calificacion.setHoraI(horaI);
        calificacion.setHoraF(horaF);
        calificacion.setFechaE(fechaE);
        calificacion.setIdUser(idUser);
        calificacion.setIdEvento(idEvento);


        if (porcentaje!=-1) {
            calificacion.setPorcentaje(porcentaje);
            sql="insert into Calificacion (porcentaje,hora,idUser,idEvento,fecha,horaI,horaF,fechaE) values("+porcentaje+",'"+hora+"',"+idUser+","+idEvento+",'"+fecha+"','"+horaI+"','"+horaF+"','"+fechaE+"');";
        }
        if (comentario!=""){
            calificacion.setComentario(comentario);
            sql="insert into Calificacion (comentario,hora,idUser,idEvento,fecha,horaI,horaF,fechaE) values('"+comentario+"','"+hora+"',"+idUser+","+idEvento+",'"+fecha+"','"+horaI+"','"+horaF+"','"+fechaE+"');";
        }
        if (multimedia!=null){
            calificacion.setMultimedia(multimedia);
            sql="insert into Calificacion (multimedia,hora,idUser,idEvento,fecha,horaI,horaF,fechaE) values("+multimedia+",'"+hora+"',"+idUser+","+idEvento+",'"+fecha+"','"+horaI+"','"+horaF+"','"+fechaE+"');";
        }





    }
    public void showMensaje(String mensaje) {
        Toast toast1 = Toast.makeText(vista.getContext(), mensaje, Toast.LENGTH_SHORT);
        toast1.show();
    }

   /*public ArrayList<Bitmap> getImage(){
       ArrayList<Bitmap> a=new ArrayList<>();
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return bmp;
    }*/


}